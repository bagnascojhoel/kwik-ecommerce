package com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest;

import com.nocpah.kwik.rulesapi.common.ErrorCode;
import com.nocpah.kwik.rulesapi.common.InternationalizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ErrorDtoFactory {
    private final InternationalizationService internationalizationService;

    public ErrorDto createUnknown(String requestId, HttpStatus httpStatus, Exception exception) {
        return ErrorDto.of(
                ErrorCode.UNKNOWN.getMessageCode(),
                internationalizationService.get(ErrorCode.UNKNOWN),
                internationalizationService.get(ErrorCode.UNKNOWN),
                httpStatus.name(),
                requestId
        );
    }
}
