package com.nocpah.kwik.rulesapi.fixture.input;

import com.nocpah.kwik.rulesapi.application.usecase.create_menu_item.CreateMenuItemInput;
import com.nocpah.kwik.rulesapi.fixture.MenuItemFixture;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateMenuItemInputFixture {
    public static CreateMenuItemInput caeserSalad() {
        return new CreateMenuItemInput(
                MenuItemFixture.CAESAR_SALAD_NAME,
                MenuItemFixture.CAESAR_SALAD_DESC,
                MenuItemFixture.CAESAR_SALAD_PRICE,
                MenuItemFixture.CAESAR_SALAD_URL);
    }
}
