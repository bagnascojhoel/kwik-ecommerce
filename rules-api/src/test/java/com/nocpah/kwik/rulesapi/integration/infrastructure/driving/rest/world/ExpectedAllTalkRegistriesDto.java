package com.nocpah.kwik.rulesapi.integration.infrastructure.driving.rest.world;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ExpectedAllTalkRegistriesDto {
    private String sayerName;
    private String worldName;
    private String sayerSpeech;
    private String worldResponse;
    private LocalDateTime talkedAt;
}
