package com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.presenter;

import com.nocpah.kwik.rulesapi.application.usecase.say_to_the_world.SayToTheWorldPresenter;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.JsonHttpPresenter;
import org.springframework.http.HttpStatus;

public class RestSayToTheWorldHttpPresenter extends JsonHttpPresenter<Void> implements SayToTheWorldPresenter {
    @Override
    public void onSuccess() {
        this.responseBuilder()
                .status(HttpStatus.CREATED)
                .build();
    }
}
