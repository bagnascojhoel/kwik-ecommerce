package com.nocpah.kwik.rulesapi.application.usecase.create_menu_item;

import com.nocpah.kwik.rulesapi.domain.entity.MenuItem;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class CreateMenuItemFactory {
    public static MenuItem create(CreateMenuItemInput input) {
        return new MenuItem(input.name, input.description, input.price, input.imageUrl);
    }
}
