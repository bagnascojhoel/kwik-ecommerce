package com.nocpah.kwik.rulesapi.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    UNKNOWN("unknown");
    private final String messageCode;
}
