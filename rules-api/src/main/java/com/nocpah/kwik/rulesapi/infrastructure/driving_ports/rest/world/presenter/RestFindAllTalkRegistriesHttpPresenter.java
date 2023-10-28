package com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.presenter;

import com.nocpah.kwik.rulesapi.application.query.find_all_talk_registries.FindAllTalkRegistriesOutput;
import com.nocpah.kwik.rulesapi.application.query.find_all_talk_registries.FindAllTalkRegistriesPresenter;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.JsonHttpPresenter;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.dto.AllTalkRegistriesDto;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.factory.FindAllTalkRegistriesResponseFactory;
import org.springframework.http.HttpStatus;

import java.util.List;

public class RestFindAllTalkRegistriesHttpPresenter extends JsonHttpPresenter<List<AllTalkRegistriesDto>> implements FindAllTalkRegistriesPresenter {
    @Override
    public void onSuccess(List<FindAllTalkRegistriesOutput> value) {
        this.responseBuilder()
                .body(FindAllTalkRegistriesResponseFactory.create(value))
                .status(HttpStatus.OK)
                .build();
    }
}
