package br.com.kwikecommerce.api.code.random;

import br.com.kwikecommerce.api.code.ReflectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.jeasy.random.EasyRandom;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;


@Component
public record Random(
    EntityManagerFactory entityManagerFactory,
    EasyRandom easyRandom,
    ReflectionUtils reflectionUtils
) {

    public static PrimitiveRandom PRIMITIVE;
    public static ObjectRandom OBJECT;
    public static EntityRandom ENTITY;

    public Random {
        PRIMITIVE = new PrimitiveRandom();
        OBJECT = new ObjectRandom();
        ENTITY = new EntityRandom(entityManagerFactory);
    }

    public static <T extends Enum<?>> T nextEnum(Class<T> baseEnum) {
        var enumLength = baseEnum.getEnumConstants().length;
        var index = RandomUtils.nextInt(0, enumLength);
        return baseEnum.getEnumConstants()[index];
    }

}
