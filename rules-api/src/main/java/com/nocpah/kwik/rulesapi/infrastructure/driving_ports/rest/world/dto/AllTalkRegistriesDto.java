package com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@Accessors(chain = true)
@Data
public class AllTalkRegistriesDto {
    private String sayerName;
    private String worldName;
    private String sayerSpeech;
    private String worldResponse;
    private LocalDateTime talkedAt;
}
