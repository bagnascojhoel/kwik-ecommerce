package br.com.kwikecommerce.api.controller.v1;

import br.com.kwikecommerce.api.application.dto.ExceptionResponse;
import br.com.kwikecommerce.api.application.dto.FieldValidationResponse;
import br.com.kwikecommerce.api.application.dto.FieldValidationResponse.FieldValidation;
import br.com.kwikecommerce.api.exception.base.NotFoundException;
import br.com.kwikecommerce.api.message.ExceptionMessageKey;
import br.com.kwikecommerce.api.message.MessageKey;
import br.com.kwikecommerce.api.application.service.logging.LogService;
import br.com.kwikecommerce.api.application.service.message.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestControllerAdvice
public record ExceptionController(
    MessageService messageService,
    LogService logService
) {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public FieldValidationResponse handleFieldValidations(MethodArgumentNotValidException ex) {
        return buildExceptionResponse(ex.getFieldErrors());
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
        var message = messageService.fetch(messageKey, fields);
        return ExceptionResponse.builder()
            .message(message)
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
}
