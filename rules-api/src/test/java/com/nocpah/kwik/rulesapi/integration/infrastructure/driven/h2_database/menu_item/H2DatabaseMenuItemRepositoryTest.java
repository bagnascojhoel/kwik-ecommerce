package com.nocpah.kwik.rulesapi.integration.infrastructure.driven.h2_database.menu_item;

import com.nocpah.kwik.rulesapi.domain.repository.MenuItemRepository;
import com.nocpah.kwik.rulesapi.fixture.MenuItemFixture;
import com.nocpah.kwik.rulesapi.infrastructure.driven_ports.h2_database.menu_item.JpaMenuItem;
import com.nocpah.kwik.rulesapi.infrastructure.driven_ports.h2_database.menu_item.JpaMenuItemMapper;
import com.nocpah.kwik.rulesapi.integration.infrastructure.driven.h2_database.AbstractH2DatabaseIntegrationTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

class H2DatabaseMenuItemRepositoryTest extends AbstractH2DatabaseIntegrationTest {
    final MenuItemRepository h2DatabaseMenuItemRepository;
    final SimpleJpaRepository<JpaMenuItem, String> jpaMenuItemTooling;

    @Autowired
    public H2DatabaseMenuItemRepositoryTest(
            @Qualifier("h2-database") MenuItemRepository h2DatabaseMenuItemRepository,
            EntityManager entityManager) {
        this.h2DatabaseMenuItemRepository = h2DatabaseMenuItemRepository;
        this.jpaMenuItemTooling = new SimpleJpaRepository<>(JpaMenuItem.class, entityManager);
    }

    @Test
    void shouldPersistMenuItem() {
        var menuItem = MenuItemFixture.caesarSalad();

        h2DatabaseMenuItemRepository.save(menuItem);

        var itemFound = jpaMenuItemTooling.findById(menuItem.getCode().getValue());
        Assertions.assertThat(itemFound).isPresent();
        var recoveredItem = JpaMenuItemMapper.map(itemFound.get());
        Assertions.assertThat(recoveredItem).isEqualTo(menuItem);
    }
}
