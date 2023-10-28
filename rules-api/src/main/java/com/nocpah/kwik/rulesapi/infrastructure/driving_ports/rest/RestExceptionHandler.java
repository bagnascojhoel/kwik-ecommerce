package com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler {
    private final ErrorDtoFactory errorDtoFactory;

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDto> handleUnknownException(Exception exception, WebRequest webRequest) {
        var dto = this.errorDtoFactory.createUnknown(this.getRequestId(), HttpStatus.INTERNAL_SERVER_ERROR, exception);
        log.error("key=error-unknown", exception);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(dto);

    }

    private String getRequestId() {
        return (String) RequestContextHolder.currentRequestAttributes().getAttribute("request-id", 0);
    }
}
