package com.nocpah.kwik.rulesapi.infrastructure.driven_ports.h2_database.menu_item;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = JpaMenuItem.class, idClass = String.class)
interface JpaMenuItemRepository {
    JpaMenuItem save(JpaMenuItem jpaMenuItem);
}
