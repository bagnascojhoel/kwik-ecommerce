package br.com.kwikecommerce.api.code;

import br.com.kwikecommerce.api.code.exception.PropertySettingException;
import br.com.kwikecommerce.api.model.AbstractEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class ReflectionUtils {

    @RequiredArgsConstructor
    private enum AccessorMethodType {
        GETTER("get"),
        SETTER("set");

        private final String prefix;
    }

    public static <T> void invokeSetters(T object, Map<String, Object> properties) {
        for (var entry : properties.entrySet())
            invokeSetter(object, entry.getKey(), entry.getValue());
    }

    public static <T extends AbstractEntity> void invokeSettersWithAnnotation(
        T object,
        Object value,
        Class<? extends Annotation> annotationClass
    ) {
        var fields = object.getClass().getDeclaredFields();

        var properties = new HashMap<Field, Object>();
        for (var field : fields)
            if (field.isAnnotationPresent(annotationClass))
                properties.put(field, value);

        invokeSettersByField(object, properties);
    }

    public static <T> void invokeSettersByField(T object, Map<Field, Object> properties) {
        for (var entry : properties.entrySet())
            invokeSetter(object, entry.getKey(), entry.getValue());
    }

    public static <T> void invokeSetter(T object, String fieldName, Object value) {
        try {
            // TODO: 03/07/2021 Como settar valores em objetos de Join. Exemplo companyId através de um objeto Categoria 
            Field field = object.getClass().getDeclaredField(fieldName);
            Method setter = findSetterMethod(object.getClass(), field);
            setter.invoke(object, field.getType().cast(value));
        } catch (ReflectiveOperationException ex) {
            throw new PropertySettingException(fieldName);
        }
    }

    public static <T> void invokeSetter(T object, Field field, Object value) {
        try {
            Method setter = findSetterMethod(object.getClass(), field);
            setter.invoke(object, value);
        } catch (ReflectiveOperationException ex) {
            throw new PropertySettingException(field.getName());
        }
    }

    public static <T> List<Field> findFieldsWithAnnotation(Class<T> aClass, Class<? extends Annotation>... annotations) {
        var fields = aClass.getDeclaredFields();

        var result = new ArrayList<Field>();
        for (var field : fields)
            if (containsAnyAnnotation(field, annotations))
                result.add(field);

        return result;
    }

    private static <T> boolean containsAnyAnnotation(Field field, Class<? extends Annotation>... annotations) {
        for (var annotation : annotations)
            if (field.isAnnotationPresent(annotation))
                return true;

        return false;
    }

    private static Method findSetterMethod(
        Class<?> baseClass,
        Field field
    ) throws NoSuchMethodException, NoSuchFieldException {
        var methodName = buildAccessorMethodName(AccessorMethodType.SETTER, field.getName());
        var fieldType = field.getType();
        return baseClass.getMethod(methodName, fieldType);
    }

    private static String buildAccessorMethodName(AccessorMethodType accessorMethodType, String fieldName) {
        var formattedMethodName = fieldName.transform((name) -> {
            var firstCharacter = Character.toUpperCase(fieldName.charAt(0));
            var remainingCharacters = fieldName.substring(1);
            return firstCharacter + remainingCharacters;
        });

        return accessorMethodType.prefix + formattedMethodName;
    }

}
