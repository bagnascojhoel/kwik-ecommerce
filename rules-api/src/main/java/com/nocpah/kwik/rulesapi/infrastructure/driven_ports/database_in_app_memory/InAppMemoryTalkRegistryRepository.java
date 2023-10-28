package com.nocpah.kwik.rulesapi.infrastructure.driven_ports.database_in_app_memory;

import com.nocpah.kwik.rulesapi.domain.entity.TalkRegistry;
import com.nocpah.kwik.rulesapi.domain.repository.TalkRegistryRepository;

import java.util.HashMap;
import java.util.Map;

public class InAppMemoryTalkRegistryRepository implements TalkRegistryRepository {
    private final Map<String, TalkRegistry> talkRegistries;

    public InAppMemoryTalkRegistryRepository() {
        this.talkRegistries = new HashMap<>();
    }

    @Override
    public void save(TalkRegistry talkRegistry) {
        this.talkRegistries.put(talkRegistry.getCode(), talkRegistry);
    }
}
