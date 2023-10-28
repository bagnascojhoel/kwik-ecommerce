package com.nocpah.kwik.rulesapi.fixture;


import com.nocpah.kwik.rulesapi.domain.entity.World;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WorldFixture {
    public static World createWorldpah() {
        return new World("Worldpah");
    }
}
