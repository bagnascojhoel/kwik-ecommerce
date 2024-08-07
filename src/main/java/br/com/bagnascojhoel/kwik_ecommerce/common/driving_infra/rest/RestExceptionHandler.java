package br.com.bagnascojhoel.kwik_ecommerce.common.driving_infra.rest;

import br.com.bagnascojhoel.kwik_ecommerce.common.domain.AbstractResourceNotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;

@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class RestExceptionHandler implements RestExceptionHandlerApi {

    private final FailedValidationDtoFactory failedValidationDtoFactory;

    @Override
    @ExceptionHandler(AbstractResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleResourceNotFound(final HttpServletRequest httpServletRequest, final AbstractResourceNotFoundException abstractResourceNotFoundException) {
        return ErrorDto.builder()
                .typeUri("/errors/client-errors/not-founds/" + abstractResourceNotFoundException.getErrorCode())
                .title(Objects.requireNonNullElse(abstractResourceNotFoundException.getMessage(), "Resource not found"))
                .build();
    }

    // TODO Add a handler for this HttpMediaTypeNotSupportedException
    @Override
    @ExceptionHandler({
            HttpMessageNotReadableException.class,
            InvalidValueException.class,
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class,
            HttpMessageNotReadableException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleBadRequest(
            final HttpServletRequest httpServletRequest,
            final Throwable anException
    ) {
        return switch (anException.getClass().getName()) {
            case "InvalidValueException" ->
                    handleInvalidValue(httpServletRequest, (InvalidValueException) anException);
            case "MethodArgumentNotValidException" ->
                    handleMethodArgumentNotValid(httpServletRequest, (MethodArgumentNotValidException) anException);
            case "ConstraintViolationException" ->
                    handleConstraintViolation(httpServletRequest, (ConstraintViolationException) anException);
            case "HttpMessageNotReadableException" ->
                    handleHttpMessageNotReadable(httpServletRequest, (HttpMessageNotReadableException) anException);
            default ->
                    throw new UnsupportedOperationException("unable to handle exception", anException);
        };
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @Override
    public ErrorDto handleInternalServerError(
            final HttpServletRequest httpServletRequest,
            final Throwable throwable
    ) {
        var message = "internal server error, endpoint={}".replace("{}", httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());
        log.error(message, throwable);

        return ErrorDto.builder()
                .typeUri("/errors/server-errors/internal-server-error")
                .title("Something on our side went wrong")
                .build();
    }

    private ErrorDto handleInvalidValue(final HttpServletRequest httpServletRequest, final InvalidValueException invalidValueException) {
        return ErrorDto.builder()
                .typeUri("/errors/client-errors/bad-requests/failed-validation")
                .title(invalidValueException.getMessage())
                .build();
    }

    private ErrorDto handleMethodArgumentNotValid(
            final HttpServletRequest httpServletRequest,
            final MethodArgumentNotValidException methodArgumentNotValidException
    ) {
        return ErrorDto.builder()
                .typeUri("/errors/client-errors/bad-requests/failed-validation")
                .title("Some validation failed")
                .failedValidations(failedValidationDtoFactory.createAll(methodArgumentNotValidException))
                .build();
    }

    private ErrorDto handleConstraintViolation(
            final HttpServletRequest httpServletRequest,
            final ConstraintViolationException constraintViolationException
    ) {
        return ErrorDto.builder()
                .typeUri("/errors/client-errors/bad-requests/failed-validation")
                .title("Some validation failed")
                .failedValidations(failedValidationDtoFactory.createAll(constraintViolationException))
                .build();
    }

    private ErrorDto handleHttpMessageNotReadable(
            final HttpServletRequest httpServletRequest,
            final HttpMessageNotReadableException httpMessageNotReadableException
    ) {
        Throwable cause = httpMessageNotReadableException.getMostSpecificCause();
        List<FailedValidationDto> failedValidations = switch (cause.getClass().getSimpleName()) {
            case "InvalidFormatException" ->
                    failedValidationDtoFactory.createAll((InvalidFormatException) cause);
            default -> {
                log.error("http message not readable for unknown cause", httpMessageNotReadableException);
                yield null;
            }
        };

        return ErrorDto.builder()
                .typeUri("/errors/client-errors/bad-requests/failed-validation")
                .title("Some validation failed")
                .failedValidations(failedValidations)
                .build();
    }

}
