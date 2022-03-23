package br.com.kwikecommerce.api.pagination.sort;

import br.com.kwikecommerce.api.application.exception.InternalServerException;
import br.com.kwikecommerce.api.message.MessageProperty;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class SortOption {

    protected static final String PROPERTY_NAME_METHOD = "getPropertyName";

    private final Class<? extends Enum> sortOptionEnum;
    private Set<String> options;

    public Optional<String> valueOptionalOfOption(String aString) {
        if (StringUtils.isNotBlank(aString))
            for (var option : this.getOptions()) {
                if (option.equalsIgnoreCase(aString))
                    return Optional.of(option);
            }

        return Optional.empty();
    }

    public String valueOfOption(String aString) {
        return this.valueOptionalOfOption(aString)
            .orElseThrow(() -> new InternalServerException(
                MessageProperty.of("log.attempted-to-build-invalid-sort", aString)
            ));
    }

    private Set<String> getOptions() {
        if (options == null)
            this.options = this.extractOptions();

        return this.options;
    }

    private Set<String> extractOptions() {
        Enum[] enumConstants = sortOptionEnum.getEnumConstants();

        Set<String> result = new HashSet<>();
        for (Enum enumConstant : enumConstants) {
            result.add(this.invokeGetPropertyName(enumConstant));
        }

        return result;
    }

    private String invokeGetPropertyName(Enum enumConstant) {
        try {
            return (String) enumConstant.getClass().getMethod(PROPERTY_NAME_METHOD).invoke(enumConstant);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new InternalServerException(MessageProperty.of("log.kwik-sort-option-must-have-property-name-getter"));
        }
    }

}
