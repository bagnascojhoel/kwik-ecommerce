package com.nocpah.kwik.rulesapi.fixture;

import com.nocpah.kwik.rulesapi.domain.entity.Restaurant;
import com.nocpah.kwik.rulesapi.domain.entity.RestaurantCode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RestaurantFixture {
    public Restaurant habbibs() {
        return new Restaurant(
                new RestaurantCode("90230ac8-406b-4179-b3e9-b29960f58b64"),
                "Habbib's Canoas"
        );
    }
}
