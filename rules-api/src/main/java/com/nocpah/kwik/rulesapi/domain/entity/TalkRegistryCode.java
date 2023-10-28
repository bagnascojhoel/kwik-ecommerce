package com.nocpah.kwik.rulesapi.domain.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TalkRegistryCode {
    private final String value;

    public TalkRegistryCode(World world, String sayer, LocalDateTime talkedAt) {
        var worldPart = world.getName().substring(0, 4);
        var sayerPart = sayer.substring(0, 4);
        var momentPart = talkedAt.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssnn")).substring(0, 16);
        this.value = (worldPart + sayerPart + momentPart).toUpperCase();
    }

    public String getCode() {
        return this.value;
    }
}
