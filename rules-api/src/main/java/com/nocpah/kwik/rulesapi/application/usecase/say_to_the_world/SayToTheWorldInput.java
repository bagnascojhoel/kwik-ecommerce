package com.nocpah.kwik.rulesapi.application.usecase.say_to_the_world;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SayToTheWorldInput {
    private final String speech;
    private final String sayer;
}
