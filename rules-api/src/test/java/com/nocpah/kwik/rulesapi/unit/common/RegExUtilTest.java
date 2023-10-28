package com.nocpah.kwik.rulesapi.unit.common;

import com.nocpah.kwik.rulesapi.common.RegExUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RegExUtilTest {
    @Test
    void shouldValidateRegularExpressionCorrectly() {
        var onlyNumbers = "1234";
        var mixed = "abc12";
        var onlyNumbersRegEx = "^[0-9]*$";

        var resultForOnlyNumbers = RegExUtil.matches(onlyNumbersRegEx, onlyNumbers);
        var resultForMixed = RegExUtil.matches(onlyNumbersRegEx, mixed);

        Assertions.assertThat(resultForMixed).isFalse();
        Assertions.assertThat(resultForOnlyNumbers).isTrue();
    }

    @Test
    void shouldBeFalseWhenPatternIsNull() {
        var value = "1234";

        var actual = RegExUtil.matches(null, value);

        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void shouldBeFalseWhenValueIsNull() {
        var onlyNumbersRegEx = "^[0-9]*$";

        var actual = RegExUtil.matches(onlyNumbersRegEx, null);

        Assertions.assertThat(actual).isFalse();
    }
}
