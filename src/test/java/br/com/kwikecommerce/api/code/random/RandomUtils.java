package br.com.kwikecommerce.api.code.random;

import br.com.kwikecommerce.api.code.ReflectionRandomUtils;
import br.com.kwikecommerce.api.code.ReflectionUtils;
import lombok.experimental.UtilityClass;
import org.jeasy.random.EasyRandom;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import static java.util.Objects.nonNull;


@UtilityClass
public class RandomUtils {

    private final EasyRandom easyRandom = new EasyRandom();

    public static <T> T nextObject(Class<T> aClass) {
        var result = easyRandom.nextObject(aClass);

        // TODO: 02/07/2021 Pegar fields do objeto e settar com respeito as constraints
        handleSizeConstraints(aClass, result);
        handleMinMaxConstraints(aClass, result);

        return result;
    }

    private static <T> void handleMinMaxConstraints(Class<T> aClass, T target) {
        var fields = ReflectionUtils.findFieldsWithAnnotation(aClass, Min.class);

        for (var field : fields) {
            var minAnnotation = field.getAnnotation(Min.class);
            var maxAnnotation = field.getAnnotation(Max.class);
            long min = nonNull(minAnnotation) ? minAnnotation.value() : Long.MIN_VALUE;
            long max = nonNull(maxAnnotation) ? maxAnnotation.value() : Long.MAX_VALUE;
            var value = ReflectionRandomUtils.getMinMaxValue(field.getType(), min, max);
            ReflectionUtils.invokeSetter(target, field, value);
        }
    }

    private static <T> void handleSizeConstraints(Class<T> aClass, T target) {
        var fields = ReflectionUtils.findFieldsWithAnnotation(aClass, Size.class);

        for (var field : fields) {
            int maxSize = field.getAnnotation(Size.class).max();
            int minSize = field.getAnnotation(Size.class).min();
            var value = ReflectionRandomUtils.getSizeableValue(field.getType(), minSize, maxSize);
            ReflectionUtils.invokeSetter(target, field, value);
        }
    }

}
