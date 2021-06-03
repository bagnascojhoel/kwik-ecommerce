package br.com.kwikecommerce.api.controller;

import br.com.kwikecommerce.api.dto.general.ExceptionResponseDto;
import br.com.kwikecommerce.api.dto.general.FieldValidationResponseDto;
import br.com.kwikecommerce.api.dto.general.FieldValidationResponseDto.FieldValidation;
import br.com.kwikecommerce.api.exception.base.NotFoundException;
import br.com.kwikecommerce.api.message.ExceptionMessageKey;
import br.com.kwikecommerce.api.message.MessageKey;
import br.com.kwikecommerce.api.service.application.logging.LoggingService;
import br.com.kwikecommerce.api.service.application.message.MessageService;
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
    LoggingService loggingService
) {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public FieldValidationResponseDto handleFieldValidations(MethodArgumentNotValidException ex) {
        return buildExceptionResponse(ex.getFieldErrors());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponseDto handleNotFound(NotFoundException ex) {
        return buildExceptionResponse(ex.getMessageKey(), ex.getFields());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseDto handleAnyException(Exception ex) {
        loggingService.logWarning("An unknown exception has occurred", ex);
        return buildExceptionResponse(ExceptionMessageKey.UNKNOWN);
    }

    private ExceptionResponseDto buildExceptionResponse(MessageKey messageKey, Object... fields) {
        var message = messageService.fetch(messageKey, fields);
        return ExceptionResponseDto.builder()
            .message(message)
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
}
