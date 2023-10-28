package com.nocpah.kwik.rulesapi.fixture;

import com.nocpah.kwik.rulesapi.domain.entity.MenuItem;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MenuItemFixture {
    public static String CAESAR_SALAD_NAME = "Caesar's Salad";
    public static String CAESAR_SALAD_DESC = "The best Caesar's salad you'll ever taste.";
    public static BigDecimal CAESAR_SALAD_PRICE = new BigDecimal("15.50");
    public static String CAESAR_SALAD_URL = "my-image-url";

    public static MenuItem grilledFish() {
        return MenuItem.recover(
                "90230ac8-406b-4179-b3e9-b29960f58b64",
                "Grilled Fish",
                "Seasoned and grilled fish.",
                new BigDecimal("24.99"),
                "my-image-url",
                false);
    }

    public static MenuItem caesarSalad() {
        return MenuItem.recover(
                "e920ba41-de09-4a68-8266-16ee17d5bbc7",
                CAESAR_SALAD_NAME,
                CAESAR_SALAD_DESC,
                CAESAR_SALAD_PRICE,
                CAESAR_SALAD_URL,
                true);
    }
}
