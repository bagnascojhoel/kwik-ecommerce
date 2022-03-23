package br.com.kwikecommerce.api.pagination.sort;

import br.com.kwikecommerce.api.message.MessageProperty;
import br.com.kwikecommerce.api.application.exception.InternalServerException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SortOptionFactory {

    private static final Map<Class<? extends Enum>, SortOption> createdSortOptions = new HashMap<>();

    static SortOption create(Class<? extends Enum> anEnum) {
        if (!createdSortOptions.containsKey(anEnum)) {
            if (!allowsGetOfPropertyName(anEnum))
                throw new InternalServerException(MessageProperty.of("log.kwik-sort-option-must-have-property-name-getter"));

            createdSortOptions.put(anEnum, new SortOption(anEnum));
        }

        return createdSortOptions.get(anEnum);
    }

    private static boolean allowsGetOfPropertyName(Class<? extends Enum> anEnum) {
        Method[] enumMethods = anEnum.getMethods();

        for (var method : enumMethods)
            if (method.getName().equals(SortOption.PROPERTY_NAME_METHOD))
                return true;

        return false;
    }

}
