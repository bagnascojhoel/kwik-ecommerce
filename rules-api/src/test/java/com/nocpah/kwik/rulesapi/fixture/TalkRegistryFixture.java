package com.nocpah.kwik.rulesapi.fixture;

import com.nocpah.kwik.rulesapi.domain.entity.TalkRegistry;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TalkRegistryFixture {
    public static TalkRegistry henriqueSaidHelloToWorldpah() {
        return new TalkRegistry(
                WorldFixture.createWorldpah(),
                SayerFixture.henrique(),
                "Hello!",
                LocalDateTime.of(2022, 5, 12, 14, 30, 25, 56)
        );
    }
}
