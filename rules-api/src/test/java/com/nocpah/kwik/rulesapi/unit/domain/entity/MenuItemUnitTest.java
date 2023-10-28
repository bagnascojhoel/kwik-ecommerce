package com.nocpah.kwik.rulesapi.unit.domain.entity;

import com.nocpah.kwik.rulesapi.domain.entity.MenuItem;
import com.nocpah.kwik.rulesapi.fixture.MenuItemFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class MenuItemUnitTest {
    @Test
    void shouldBeAbleToRecoverItemsFromPreviousState() {
        var expected = new MenuItem("name", "description", new BigDecimal("12.55"), "my-image-url");

        var actual = MenuItem.recover(
                expected.getCode().getValue(), "name", "description", new BigDecimal("12.55"), "my-image-url", expected.canBeSold());

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldCreateItemThatCannotBeSoldByDefault() {
        var subject = new MenuItem("name", "desc", new BigDecimal("50"), "url");

        var sellableState = subject.canBeSold();

        Assertions.assertThat(sellableState).isFalse();
    }

    @Test
    void shouldCreateItemsWithDifferentCodes() {
        var subject = new MenuItem("name", "desc", new BigDecimal("50"), "url");

        var actual = new MenuItem("name", "desc", new BigDecimal("50"), "url");

        Assertions.assertThat(actual.getCode()).isNotEqualTo(subject.getCode());
    }

    @Test
    void shouldDisableSelling() {
        var subject = MenuItemFixture.caesarSalad();

        subject.disableSale();
        var actual = subject.isCanBeSold();

        Assertions.assertThat(actual).isFalse();
    }


    @Test
    void shouldEnableSelling() {
        var subject = MenuItemFixture.grilledFish();

        subject.enableSale();
        var actual = subject.isCanBeSold();

        Assertions.assertThat(actual).isTrue();
    }
}
