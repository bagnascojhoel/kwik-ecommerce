package com.nocpah.kwik.rulesapi.unit.domain.entity;

import com.nocpah.kwik.rulesapi.domain.entity.TalkRegistryCode;
import com.nocpah.kwik.rulesapi.fixture.WorldFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TalkRegistryCodeUnitTest {
    @Test
    void shouldGenerateCodeValueWhenInstantiating() {
        var world = WorldFixture.createWorldpah();
        var sayer = "Henrique Knabach";
        var talkedAt = LocalDateTime.of(2022, 10, 5, 10, 12, 35, 46);
        var expected = "WORLHENR2022100510123546";

        var actual = new TalkRegistryCode(world, sayer, talkedAt);
        Assertions.assertThat(actual.getCode()).isEqualTo(expected);
    }
}
