package br.com.kwikecommerce.api.code.application;

import br.com.kwikecommerce.api.code.application.exception.PropertySettingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;


@Component
public class ReflectionHelper {

    @RequiredArgsConstructor
    private enum AccessorMethodType {
        GETTER("get"),
        SETTER("set");

        private final String prefix;
    }

    public Method findGetterMethod(Class<?> baseClass, String property) throws NoSuchMethodException {
        var methodName = buildAccessorMethodName(AccessorMethodType.GETTER, property);
        return baseClass.getMethod(methodName);
    }

    public <T> void invokeSetters(T object, Map<String, Object> properties) {
        for (var entry : properties.entrySet()) {
            try {
                Method setter = findSetterMethod(object.getClass(), entry.getKey());
                setter.invoke(object, entry.getValue());
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
                throw new PropertySettingException(entry.getKey());
            }
        }
    }

    private Method findSetterMethod(Class<?> baseClass, String property) throws NoSuchMethodException {
        var methodName = buildAccessorMethodName(AccessorMethodType.SETTER, property);
        return baseClass.getMethod(methodName);
    }

    private String buildAccessorMethodName(AccessorMethodType accessorMethodType, String methodName) {
        var formattedMethodName = methodName.transform((name) -> {
            var firstCharacter = Character.toUpperCase(methodName.charAt(0));
            var remainingCharacters = methodName.substring(1);
            return firstCharacter + remainingCharacters;
        });

        return accessorMethodType.prefix + formattedMethodName;
    }

}
