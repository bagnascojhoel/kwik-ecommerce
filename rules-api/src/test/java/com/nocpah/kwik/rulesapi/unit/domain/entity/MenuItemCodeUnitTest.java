package com.nocpah.kwik.rulesapi.unit.domain.entity;

import com.nocpah.kwik.rulesapi.domain.entity.MenuItemCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class MenuItemCodeUnitTest {
    @ParameterizedTest
    @ValueSource(strings = {" ", "my-code", "e920ba41-de09-4a68-8266-16ze17d5bbc7"})
    @NullAndEmptySource
    void shouldInterruptWhenValueIsNotAnUuid(String value) {
        Assertions.assertThatThrownBy(() -> new MenuItemCode(value))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("menu item code is invalid");
    }
}
