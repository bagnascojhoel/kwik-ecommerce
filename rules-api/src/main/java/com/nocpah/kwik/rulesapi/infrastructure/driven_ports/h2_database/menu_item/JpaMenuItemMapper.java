package com.nocpah.kwik.rulesapi.infrastructure.driven_ports.h2_database.menu_item;

import com.nocpah.kwik.rulesapi.domain.entity.MenuItem;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

// TODO This should not be exposed to outside modules
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JpaMenuItemMapper {
    public static MenuItem map(JpaMenuItem jpaMenuItem) {
        return MenuItem.recover(
                jpaMenuItem.code,
                jpaMenuItem.name,
                jpaMenuItem.description,
                jpaMenuItem.price,
                jpaMenuItem.imageUrl,
                jpaMenuItem.canBeSold
        );
    }

    public static JpaMenuItem map(MenuItem menuItem) {
        return JpaMenuItem.builder()
                .code(menuItem.getCode().getValue())
                .name(menuItem.getName())
                .description(menuItem.getDescription())
                .price(menuItem.getPrice())
                .canBeSold(menuItem.isCanBeSold())
                .imageUrl(menuItem.getImageUrl())
                .build();
    }
}
