package com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world;

import com.nocpah.kwik.rulesapi.application.query.find_all_talk_registries.FindAllTalkRegistriesQuery;
import com.nocpah.kwik.rulesapi.application.usecase.say_to_the_world.SayToTheWorldUseCase;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.UrlConstants;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.dto.AllTalkRegistriesDto;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.dto.SayToTheWorldDto;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.factory.SayToTheWorldFactory;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.presenter.RestFindAllTalkRegistriesHttpPresenter;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.presenter.RestSayToTheWorldHttpPresenter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstants.APPLICATION_PATH + "/worlds")
@RequiredArgsConstructor
public class RestWorldController implements RestWorldApiDefinition {
    private final SayToTheWorldUseCase sayHelloWorldUseCase;
    private final FindAllTalkRegistriesQuery findAllTalkRegistriesQuery;

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/say")
    public ResponseEntity<Void> sayToTheWorld(@RequestBody SayToTheWorldDto request) {
        var presenter = new RestSayToTheWorldHttpPresenter();
        this.sayHelloWorldUseCase.execute(SayToTheWorldFactory.createInput(request), presenter);
        return presenter.present();
    }

    @Override
    @GetMapping("/talks")
    public ResponseEntity<List<AllTalkRegistriesDto>> findAllTalkRegistries() {
        var presenter = new RestFindAllTalkRegistriesHttpPresenter();
        this.findAllTalkRegistriesQuery.query(presenter);
        return presenter.present();
    }
}
