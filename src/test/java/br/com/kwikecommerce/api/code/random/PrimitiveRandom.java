package br.com.kwikecommerce.api.code.random;

import org.apache.commons.lang3.RandomUtils;


public class PrimitiveRandom {

    public Long nextLong() {
        return RandomUtils.nextLong();
    }

    public Long nextLong(long startInclusive, long endExclusive) {
        return RandomUtils.nextLong(startInclusive, endExclusive);
    }

    public Integer nextInt() {
        return RandomUtils.nextInt();
    }

    public Integer nextInt(int startInclusive, int endExclusive) {
        return RandomUtils.nextInt(startInclusive, endExclusive);
    }

}
