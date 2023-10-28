package com.nocpah.kwik.rulesapi.domain.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class MenuItem {
    private final MenuItemCode code;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final String imageUrl;
    private boolean canBeSold = false;

    public MenuItem(String name, String description, BigDecimal price, String imageUrl) {
        this.code = new MenuItemCode();
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public static MenuItem recover(
            String code,
            String name,
            String description,
            BigDecimal value,
            String imageUrl,
            boolean canBeSold) {
        return new MenuItem(new MenuItemCode(code), name, description, value, imageUrl, canBeSold);
    }

    public void disableSale() {
        this.canBeSold = false;
    }

    public void enableSale() {
        this.canBeSold = true;
    }

    public boolean canBeSold() {
        return canBeSold;
    }
}
