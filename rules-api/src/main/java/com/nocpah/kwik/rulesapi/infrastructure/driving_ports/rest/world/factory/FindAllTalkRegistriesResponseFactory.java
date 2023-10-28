package com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.factory;

import com.nocpah.kwik.rulesapi.application.query.find_all_talk_registries.FindAllTalkRegistriesOutput;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.dto.AllTalkRegistriesDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FindAllTalkRegistriesResponseFactory {

    public static List<AllTalkRegistriesDto> create(List<FindAllTalkRegistriesOutput> dataList) {
        return dataList.stream()
                .map(FindAllTalkRegistriesResponseFactory::create)
                .collect(Collectors.toList());
    }

    public static AllTalkRegistriesDto create(FindAllTalkRegistriesOutput data) {
        return new AllTalkRegistriesDto()
                .setSayerName(data.getSayerName())
                .setWorldName(data.getWorldName())
                .setSayerSpeech(data.getSayerSpeech())
                .setWorldResponse(data.getWorldResponse())
                .setTalkedAt(data.getTalkedAt());
    }
}
