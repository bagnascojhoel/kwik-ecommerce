package com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class ErrorDto {
    private final String type;
    private final String title;
    private final String detail;
    private final String status;
    private final String instance;
}
