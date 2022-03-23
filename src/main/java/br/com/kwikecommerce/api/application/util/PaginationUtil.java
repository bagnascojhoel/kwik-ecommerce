package br.com.kwikecommerce.api.application.util;

import br.com.kwikecommerce.api.pagination.PageRequest;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@UtilityClass
public class PaginationUtil {

    private static final byte PROPERTY_POSITION = 0;
    private static final byte DIRECTION_POSITION = 1;

    // TODO jhoel.bagnasco 11/09/2021 | Validar se a propriedade utilizada na ordenação existe na entidade target
    public static Pageable buildPageableWithoutSort(PageRequest pageRequest) {
        return org.springframework.data.domain.PageRequest.of(
            pageRequest.getPage(),
            pageRequest.getLimit()
        );
    }

    private static Sort buildSort(String sortString) {
        var sortData = extractSortData(sortString);
        String propertyName = sortData.get(PROPERTY_POSITION);
        var direction = Sort.Direction.valueOf(sortData.get(DIRECTION_POSITION));
        return Sort.by(direction, propertyName);
    }

    private static List<String> extractSortData(String sortString) {
        return Arrays.stream(sortString.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    }

}
