package com.nocpah.kwik.rulesapi.application.query.find_all_talk_registries;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class FindAllTalkRegistriesOutput {
    private String talkRegistryCode;
    private String sayerName;
    private String worldName;
    private String sayerSpeech;
    private String worldResponse;
    private LocalDateTime talkedAt;
}
