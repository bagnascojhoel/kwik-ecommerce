package com.nocpah.kwik.rulesapi.application.usecase.say_to_the_world;

import com.nocpah.kwik.rulesapi.domain.entity.TalkRegistry;
import com.nocpah.kwik.rulesapi.domain.entity.World;
import com.nocpah.kwik.rulesapi.domain.repository.TalkRegistryRepository;
import com.nocpah.kwik.rulesapi.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@UseCase
@RequiredArgsConstructor
public class SayToTheWorldUseCaseImpl implements SayToTheWorldUseCase {
    private final TalkRegistryRepository talkRegistryRepository;

    @Override
    public void execute(SayToTheWorldInput input, SayToTheWorldPresenter presenter) {
        var talkRegistry = new TalkRegistry(
                World.WORLDPAH,
                input.getSayer(),
                input.getSpeech(),
                LocalDateTime.now());
        this.talkRegistryRepository.save(talkRegistry);
        presenter.onSuccess();
    }
}
