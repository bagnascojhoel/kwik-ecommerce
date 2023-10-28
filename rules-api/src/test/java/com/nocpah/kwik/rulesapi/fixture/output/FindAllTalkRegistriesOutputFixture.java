package com.nocpah.kwik.rulesapi.fixture.output;

import com.nocpah.kwik.rulesapi.application.query.find_all_talk_registries.FindAllTalkRegistriesOutput;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FindAllTalkRegistriesOutputFixture {
    public static FindAllTalkRegistriesOutput createDouglas() {
        return new FindAllTalkRegistriesOutput()
                .setSayerName("Douglas")
                .setSayerSpeech("My speech")
                .setWorldName("Worldpah")
                .setWorldResponse("My response is weird")
                .setTalkedAt(LocalDateTime.of(2020, 12, 10, 13, 13, 56));

    }

    public static FindAllTalkRegistriesOutput createRodrigo() {
        return new FindAllTalkRegistriesOutput()
                .setSayerName("Rodrigo")
                .setSayerSpeech("My speech")
                .setWorldName("Worldpah")
                .setWorldResponse("My response is weird")
                .setTalkedAt(LocalDateTime.of(2021, 12, 10, 13, 13, 56));

    }
}
