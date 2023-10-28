package com.nocpah.kwik.rulesapi.infrastructure.configuration;

import com.nocpah.kwik.rulesapi.domain.repository.TalkRegistryRepository;
import com.nocpah.kwik.rulesapi.infrastructure.driven_ports.h2_database.talk_registry.H2DatabaseTalkRegistryRepository;
import com.nocpah.kwik.rulesapi.infrastructure.driven_ports.h2_database.talk_registry.JpaTalkRegistryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@RequiredArgsConstructor
public class InfrastructureConfiguration {
    final JpaTalkRegistryRepository talkRegistryJpaRepository;

    @Bean
    @Primary
    public TalkRegistryRepository inAppMemoryWorldRepository() {
        return new H2DatabaseTalkRegistryRepository(this.talkRegistryJpaRepository);
    }
}
