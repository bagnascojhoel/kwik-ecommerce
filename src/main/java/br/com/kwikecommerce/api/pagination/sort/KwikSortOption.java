package br.com.kwikecommerce.api.pagination.sort;

import br.com.kwikecommerce.api.application.exception.InternalServerException;
import br.com.kwikecommerce.api.message.MessageProperty;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;


@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class KwikSortOption {

    private final Class<? extends Enum> sortOptionEnum;

    // TODO passar a comparar com o valor do ENUM, não da propriedade
    public String mustFindPropertyNameForOption(String sortOption) {
        return this.findPropertyNameForOption(sortOption)
            .orElseThrow(() -> new InternalServerException(
                MessageProperty.of("log.attempted-to-build-invalid-sort", sortOption)
            ));
    }

    public Optional<String> findPropertyNameForOption(String sortOption) {
        return Arrays.stream(sortOptionEnum.getEnumConstants())
            .filter(anEnum -> anEnum.name().equalsIgnoreCase(sortOption))
            .map(anEnum -> (SortOption) anEnum)
            .map(SortOption::getPropertyName)
            .findFirst();
    }

//    private String invokeGetPropertyName(Enum enumConstant) {
//        try {
//            var methodName = SortOption.class.getMethods()[0].getName();
//            return (String) enumConstant.getClass().getMethod(methodName).invoke(enumConstant);
//        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//            throw new InternalServerException(MessageProperty.of("log.kwik-sort-option-must-have-property-name-getter"));
//        }
//    }

}
