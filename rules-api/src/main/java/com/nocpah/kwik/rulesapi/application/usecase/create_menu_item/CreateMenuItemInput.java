package com.nocpah.kwik.rulesapi.application.usecase.create_menu_item;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class CreateMenuItemInput {
    protected final String name;
    protected final String description;
    protected final BigDecimal price;
    protected final String imageUrl;
}
