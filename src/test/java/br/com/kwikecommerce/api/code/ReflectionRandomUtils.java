package br.com.kwikecommerce.api.code;

import br.com.kwikecommerce.api.code.exception.UnknownTypeException;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.jeasy.random.EasyRandom;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;


@UtilityClass
public class ReflectionRandomUtils {

    private static final EasyRandom easyRandom = new EasyRandom();

    public static <T> T getSizeableValue(Class<T> type, int min, int max) {

        Object generated;
        if (String.class.isAssignableFrom(type))
            generated = RandomStringUtils.random(max);
        else if (Collection.class.isAssignableFrom(type))
            throw new RuntimeException("Cannot handle @Size on Collections");
//            generated = generateCollection(type, min, max);
        else
            throw new UnknownTypeException(type.getTypeName());

        return type.cast(generated);

    }

//    private static <C extends Collection<?>> C generateCollection(Class<C> type, int min, int max) {
//        // TODO: 04/07/2021 implementar essa criação de coleções de acordo com a interface
//        //  Map não é uma collection
//
//        if (type.getTypeName().equals("List") || type.getTypeName().equals("Set")) {
//            Collection<?> result = type.getTypeName().equals("List")
//                ? new ArrayList<>()
//                : new HashSet<>();
//
//            for (var i = 0; i < min; i++)
//                result.add(easyRandom.nextObject(ty))
//
//            return result;
//        } else {
//
//        }
//
//        return result;
//    }

    public static <T> T getMinMaxValue(Class<T> type, long min, long max) {
        Object generated;

        if (isAssignableFromAny(type, Integer.class, Short.class, Byte.class)) {
            var intMin = (int) min != min ? Integer.MIN_VALUE : Math.toIntExact(min);
            var intMax = (int) max != max ? Integer.MAX_VALUE : Math.toIntExact(max);
            generated = RandomUtils.nextInt(intMin, intMax);
        } else if (isAssignableFromAny(type, Long.class))
            generated = RandomUtils.nextLong(min, max);
        else if (isAssignableFromAny(type, Double.class))
            generated = RandomUtils.nextDouble(min, max);
        else if (isAssignableFromAny(type, Float.class))
            generated = RandomUtils.nextFloat(min, max);
        else if (isAssignableFromAny(type, BigDecimal.class, BigInteger.class))
            generated = easyRandom.nextObject(type);
        else
            throw new UnknownTypeException(type.getName());

        return type.cast(generated);
    }

    private static boolean isAssignableFromAny(Class<?> type, Class<?>... assigns) {
        for (var assign : assigns) {
            if (type.isAssignableFrom(assign))
                return true;
        }

        return false;
    }

}
