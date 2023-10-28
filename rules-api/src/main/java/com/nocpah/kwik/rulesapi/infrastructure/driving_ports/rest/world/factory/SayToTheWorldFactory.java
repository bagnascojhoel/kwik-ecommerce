package com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.factory;

import com.nocpah.kwik.rulesapi.application.usecase.say_to_the_world.SayToTheWorldInput;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.dto.SayToTheWorldDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SayToTheWorldFactory {
    public static SayToTheWorldInput createInput(SayToTheWorldDto dto) {
        return new SayToTheWorldInput(dto.getSpeech(), dto.getSayer());
    }
}
