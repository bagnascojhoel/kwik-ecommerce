package com.nocpah.kwik.rulesapi.infrastructure.driven_ports.h2_database.talk_registry;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = JpaTalkRegistry.class, idClass = String.class)
public interface JpaTalkRegistryRepository {
    JpaTalkRegistry save(JpaTalkRegistry jpaTalkRegistry);
}
