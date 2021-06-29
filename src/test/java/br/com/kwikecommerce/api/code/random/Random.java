package br.com.kwikecommerce.api.code.random;

import org.jeasy.random.EasyRandom;


public record Random() {

    private final static EasyRandom EASY_RANDOM = new EasyRandom();

    public final static RandomPrimitive PRIMITIVE = new RandomPrimitive();
    public final static RandomObject OBJECT = new RandomObject(EASY_RANDOM);
    public final static RandomEntity ENTITY = new RandomEntity(EASY_RANDOM);

    public static <T extends Enum<?>> T nextEnum(Class<T> baseEnum) {
        var enumLength = baseEnum.getEnumConstants().length;
        var index = EASY_RANDOM.nextInt(enumLength);
        return baseEnum.getEnumConstants()[index];
    }

}
