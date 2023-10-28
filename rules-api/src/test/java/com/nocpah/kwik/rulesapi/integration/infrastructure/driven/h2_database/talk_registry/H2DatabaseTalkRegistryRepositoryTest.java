package com.nocpah.kwik.rulesapi.integration.infrastructure.driven.h2_database.talk_registry;

import com.nocpah.kwik.rulesapi.domain.repository.TalkRegistryRepository;
import com.nocpah.kwik.rulesapi.fixture.TalkRegistryFixture;
import com.nocpah.kwik.rulesapi.infrastructure.driven_ports.h2_database.talk_registry.JpaTalkRegistry;
import com.nocpah.kwik.rulesapi.integration.infrastructure.driven.h2_database.AbstractH2DatabaseIntegrationTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;


public class H2DatabaseTalkRegistryRepositoryTest extends AbstractH2DatabaseIntegrationTest {
    private final TalkRegistryRepository talkRegistryRepository;
    private final SimpleJpaRepository<JpaTalkRegistry, String> talkRegistryH2Tooling;

    @Autowired
    public H2DatabaseTalkRegistryRepositoryTest(
            @Qualifier("h2") TalkRegistryRepository talkRegistryRepository,
            EntityManager entityManager) {
        this.talkRegistryRepository = talkRegistryRepository;
        this.talkRegistryH2Tooling = new SimpleJpaRepository<>(JpaTalkRegistry.class, entityManager);
    }

    @Test
    void shouldSaveTalkRegistry() {
        var talkRegistry = TalkRegistryFixture.henriqueSaidHelloToWorldpah();
        var expected = JpaTalkRegistry.builder()
                .code(talkRegistry.getCode())
                .sayerName(talkRegistry.getSayer())
                .worldName(talkRegistry.getWorld().getName())
                .sayerSpeech(talkRegistry.getSayerSpeech())
                .worldResponse(talkRegistry.getWorldResponse())
                .talkedAt(talkRegistry.getTalkedAt())
                .build();
        this.talkRegistryRepository.save(talkRegistry);

        var actual = this.talkRegistryH2Tooling.findById(talkRegistry.getCode());
        Assertions.assertThat(actual).isPresent();
        Assertions.assertThat(actual.get()).isEqualTo(expected);
    }
}
