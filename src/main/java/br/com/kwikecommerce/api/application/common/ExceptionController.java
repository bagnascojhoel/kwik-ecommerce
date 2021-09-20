package br.com.kwikecommerce.api.application.common;

import br.com.kwikecommerce.api.application.dto.response.ExceptionResponse;
import br.com.kwikecommerce.api.application.dto.response.FieldValidationResponse;
import br.com.kwikecommerce.api.application.dto.response.FieldValidationResponse.FieldValidation;
import br.com.kwikecommerce.api.application.exception.base.NotFoundException;
import br.com.kwikecommerce.api.application.service.localization.LocalizationService;
import br.com.kwikecommerce.api.application.service.logging.LogService;
import br.com.kwikecommerce.api.message.ExceptionMessageKey;
import br.com.kwikecommerce.api.message.MessageKey;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
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


@RestControllerAdvice
public record ExceptionController(
    LocalizationService localizationService,
    LogService logService
) {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public FieldValidationResponse handleFieldValidations(MethodArgumentNotValidException ex) {
        return buildExceptionResponse(ex.getFieldErrors());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public FieldValidationResponse handleFieldValidations(ConstraintViolationException ex) {
        return buildExceptionResponse(ex.getConstraintViolations());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleNotFound(NotFoundException ex) {
        return buildExceptionResponse(ex.getMessageKey(), ex.getFields());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleAnyException(Exception ex) {
        logService.logWarning("An unknown exception has occurred", ex);
        return buildExceptionResponse(ExceptionMessageKey.UNKNOWN);
    }

    private ExceptionResponse buildExceptionResponse(MessageKey messageKey, Object... fields) {
        var message = localizationService.fetch(messageKey, fields);
        return ExceptionResponse.builder()
            .message(message)
            .build();
    }

    private FieldValidationResponse buildExceptionResponse(Set<ConstraintViolation<?>> constraintViolations) {
        var validations = new ArrayList<FieldValidation>();

        for (var constraintViolation : constraintViolations) {
            var value = Optional.ofNullable(constraintViolation.getInvalidValue())
                .map(Object::toString)
                .orElse(null);
            var message = fetchValidationMessage(constraintViolation);

            validations.add(FieldValidation.builder()
                .field(constraintViolation.getPropertyPath().toString())
                .value(value)
                .message(message)
                .build());
        }

        return FieldValidationResponse.builder()
            .validations(validations)
            .build();
    }

    private FieldValidationResponse buildExceptionResponse(List<FieldError> fieldErrors) {
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

        return FieldValidationResponse.builder()
            .validations(validations)
            .build();
    }

    private String fetchValidationMessage(ConstraintViolation<?> constraintViolation) {
        var messageKey = constraintViolation.getMessageTemplate().replace("{", "").replace("}", "");

        String message;
        try {
            message = localizationService.fetch(messageKey);
        } catch (NoSuchMessageException ex) {
            message = constraintViolation.getMessage();
        }

        return message;
    }

}
