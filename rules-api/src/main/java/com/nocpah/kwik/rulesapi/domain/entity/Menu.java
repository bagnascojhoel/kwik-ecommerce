package com.nocpah.kwik.rulesapi.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode
@Getter
public class Menu {
    private final RestaurantCode restaurantCode;
    private final List<MenuItemCode> items;

    public Menu(RestaurantCode restaurantCode, MenuItemCode... items) {
        this.restaurantCode = restaurantCode;
        this.items = Arrays.asList(items);
    }

    public void include(MenuItemCode... items) {
        this.items.addAll(Arrays.asList(items));
    }
}
