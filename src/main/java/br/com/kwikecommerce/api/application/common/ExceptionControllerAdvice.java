package br.com.kwikecommerce.api.application.common;

import br.com.kwikecommerce.api.application.dto.exception.ExceptionResponseDto;
import br.com.kwikecommerce.api.application.dto.exception.FieldValidationResponseDto;
import br.com.kwikecommerce.api.application.dto.exception.FieldValidationResponseDto.FieldValidation;
import br.com.kwikecommerce.api.application.exception.BadRequestException;
import br.com.kwikecommerce.api.application.exception.InternalServerException;
import br.com.kwikecommerce.api.application.exception.NotFoundException;
import br.com.kwikecommerce.api.message.MessageProperty;
import br.com.kwikecommerce.api.application.service.logging.LogService;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@RestControllerAdvice
public record ExceptionControllerAdvice(LogService logService) {

    // 4xx

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public FieldValidationResponseDto handleBindException(BindException ex) {
        var mappedFieldErrors = ex.getFieldErrors().stream()
            .map(fieldError -> new FieldError(
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getRejectedValue(),
                fieldError.isBindingFailure(),
                fieldError.getCodes(),
                fieldError.getArguments(),
                MessageProperty.use("e.exception-controller-advice.invalid-value-binded")
            ))
            .collect(Collectors.toList());
        return this.buildExceptionResponse(mappedFieldErrors);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public FieldValidationResponseDto handleFieldValidations(MethodArgumentNotValidException ex) {
        return buildExceptionResponse(ex.getFieldErrors());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public FieldValidationResponseDto handleFieldValidations(ConstraintViolationException ex) {
        return buildExceptionResponse(ex.getConstraintViolations());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponseDto handleNotFound(BadRequestException ex) {
        return buildExceptionResponse(ex.getTextForClient());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponseDto handleNotFound(NotFoundException ex) {
        return buildExceptionResponse(ex.getTextForClient());
    }

    // 5xx

    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseDto handleInternalServerException(
        InternalServerException internalServerException
    ) {
        logService.logError(internalServerException.getLogMessage().getText(), internalServerException.getCause());
        return buildExceptionResponse(internalServerException.getTextForClient());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseDto handleAnyException(Exception ex) {
        logService.logError(MessageProperty.use("log.unknown-error"), ex);
        return buildExceptionResponse(MessageProperty.of("e.unknown"));
    }

    private ExceptionResponseDto buildExceptionResponse(MessageProperty messageProperty) {
        return ExceptionResponseDto.builder()
            .message(messageProperty.getText())
            .build();
    }

    private FieldValidationResponseDto buildExceptionResponse(Set<ConstraintViolation<?>> constraintViolations) {
        var validations = new ArrayList<FieldValidation>();

        for (var constraintViolation : constraintViolations) {
            var value = Optional.ofNullable(constraintViolation.getInvalidValue())
                .map(Object::toString)
                .orElse(null);
            var message = getValidationMessage(constraintViolation);

            validations.add(FieldValidation.builder()
                .field(constraintViolation.getPropertyPath().toString())
                .value(value)
                .message(message)
                .build());
        }

        return FieldValidationResponseDto.builder()
            .validations(validations)
            .build();
    }

    private FieldValidationResponseDto buildExceptionResponse(List<FieldError> fieldErrors) {
        var validations = new ArrayList<FieldValidation>();

        for (var fieldError : fieldErrors) {
            var value = Optional.ofNullable(fieldError.getRejectedValue())
                .map(Object::toString)
                .orElse(null);

            validations.add(FieldValidation.builder()
                .field(fieldError.getField())
                .value(value)
                .message(fieldError.getDefaultMessage())
                .build());
        }

        return FieldValidationResponseDto.builder()
            .validations(validations)
            .build();
    }

    private String getValidationMessage(ConstraintViolation<?> constraintViolation) {
        var messageKey = constraintViolation.getMessageTemplate().replace("{", "").replace("}", "");

        String message;
        try {
            message = MessageProperty.use(messageKey);
        } catch (NoSuchMessageException ex) {
            message = constraintViolation.getMessage();
        }

        return message;
    }

}
