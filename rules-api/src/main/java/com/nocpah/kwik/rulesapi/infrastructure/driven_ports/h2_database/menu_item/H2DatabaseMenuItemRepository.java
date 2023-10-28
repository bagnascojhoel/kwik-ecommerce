package com.nocpah.kwik.rulesapi.infrastructure.driven_ports.h2_database.menu_item;

import com.nocpah.kwik.rulesapi.domain.entity.MenuItem;
import com.nocpah.kwik.rulesapi.domain.repository.MenuItemRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository("h2-database")
public class H2DatabaseMenuItemRepository implements MenuItemRepository {
    private final JpaMenuItemRepository jpaMenuItemRepository;

    public H2DatabaseMenuItemRepository(EntityManager entityManager) {
        var repositoryFactory = new JpaRepositoryFactory(entityManager);
        this.jpaMenuItemRepository = repositoryFactory.getRepository(JpaMenuItemRepository.class);
    }

    @Override
    public void save(MenuItem menuItem) {
        var jpaMenuItem = JpaMenuItemMapper.map(menuItem);
        this.jpaMenuItemRepository.save(jpaMenuItem);
    }
}
