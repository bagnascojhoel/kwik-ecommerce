package com.nocpah.kwik.rulesapi.domain.entity;


import com.nocpah.kwik.rulesapi.common.CommonRegularExpressions;
import com.nocpah.kwik.rulesapi.common.RegExUtil;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.util.Assert;

import java.util.UUID;


@Getter
@EqualsAndHashCode
public final class MenuItemCode {
    private final String value;

    public MenuItemCode(String value) {
        Assert.state(RegExUtil.matches(CommonRegularExpressions.UUID, value), "menu item code is invalid");
        this.value = value;
    }

    public MenuItemCode() {
        this.value = UUID.randomUUID().toString();
    }
}
