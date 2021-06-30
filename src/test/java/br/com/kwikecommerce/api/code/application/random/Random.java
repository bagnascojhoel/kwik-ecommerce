package br.com.kwikecommerce.api.code.application.random;

import br.com.kwikecommerce.api.code.application.ReflectionHelper;
import org.jeasy.random.EasyRandom;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;


@Component
public record Random(
    EntityManagerFactory entityManagerFactory,
    EasyRandom easyRandom,
    ReflectionHelper reflectionHelper
) {
    private static EasyRandom EASY_RANDOM;

    public static PrimitiveRandom PRIMITIVE;
    public static ObjectRandom OBJECT;
    public static EntityRandom ENTITY;

    public Random {
        var entityManager = entityManagerFactory.createEntityManager();
        EASY_RANDOM = easyRandom;
        PRIMITIVE = new PrimitiveRandom();
        OBJECT = new ObjectRandom(easyRandom);
        ENTITY = new EntityRandom(easyRandom, entityManager, reflectionHelper);
    }

    public static <T extends Enum<?>> T nextEnum(Class<T> baseEnum) {
        var enumLength = baseEnum.getEnumConstants().length;
        var index = EASY_RANDOM.nextInt(enumLength);
        return baseEnum.getEnumConstants()[index];
    }

}
