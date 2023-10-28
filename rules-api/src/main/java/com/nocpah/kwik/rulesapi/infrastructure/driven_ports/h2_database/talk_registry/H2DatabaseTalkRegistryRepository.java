package com.nocpah.kwik.rulesapi.infrastructure.driven_ports.h2_database.talk_registry;

import com.nocpah.kwik.rulesapi.domain.entity.TalkRegistry;
import com.nocpah.kwik.rulesapi.domain.repository.TalkRegistryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository("h2")
@RequiredArgsConstructor
public class H2DatabaseTalkRegistryRepository implements TalkRegistryRepository {
    private final JpaTalkRegistryRepository talkRegistryJpaRepository;

    @Override
    public void save(TalkRegistry talkRegistry) {
        var dbTalkRegistry = JpaTalkRegistry.builder()
                .code(talkRegistry.getCode())
                .worldResponse(talkRegistry.getWorldResponse())
                .worldName(talkRegistry.getWorld().getName())
                .sayerSpeech(talkRegistry.getSayerSpeech())
                .sayerName(talkRegistry.getSayer())
                .talkedAt(talkRegistry.getTalkedAt())
                .build();
        this.talkRegistryJpaRepository.save(dbTalkRegistry);
    }
}
