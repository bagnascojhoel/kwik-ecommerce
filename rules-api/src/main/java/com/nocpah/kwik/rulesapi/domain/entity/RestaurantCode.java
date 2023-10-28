package com.nocpah.kwik.rulesapi.domain.entity;

import com.nocpah.kwik.rulesapi.common.CommonRegularExpressions;
import com.nocpah.kwik.rulesapi.common.RegExUtil;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public final class RestaurantCode {
    private final String value;

    public RestaurantCode(String value) {
        Assert.state(RegExUtil.matches(CommonRegularExpressions.UUID, value), "restaurant code is invalid");
        this.value = value;
    }
}
