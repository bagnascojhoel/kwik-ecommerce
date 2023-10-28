package com.nocpah.kwik.rulesapi.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.util.Assert;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
public class TalkRegistry {
    @Getter(AccessLevel.NONE)
    private final TalkRegistryCode code;
    private final World world;
    @Size(min = 3, max = 30)
    private final String sayer;
    private final String sayerSpeech;
    private final String worldResponse;
    private final LocalDateTime talkedAt;

    public TalkRegistry(World world, String sayer, String sayerSpeech, LocalDateTime talkedAt) {
        Assert.isTrue(world.wantsToHearFrom(sayer), "%s does not want to hear from sayer %s".formatted(world.getName(), sayer));
        this.world = world;
        this.sayerSpeech = sayerSpeech;
        this.sayer = sayer;
        this.worldResponse = world.hears(sayerSpeech);
        this.talkedAt = talkedAt;
        this.code = new TalkRegistryCode(world, sayer, talkedAt);
    }

    public String getCode() {
        return this.code.getCode();
    }
}
