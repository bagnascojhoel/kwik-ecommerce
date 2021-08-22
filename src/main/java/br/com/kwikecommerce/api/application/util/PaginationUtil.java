package br.com.kwikecommerce.api.application.util;

import br.com.kwikecommerce.api.application.dto.request.PageRequestDto;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@UtilityClass
public class PaginationUtil {

    private static final byte PROPERTY_POSITION = 0;
    private static final byte DIRECTION_POSITION = 1;

    public static Pageable buildPageable(PageRequestDto pageRequestDto) {
        var correctPage = pageRequestDto.getPage() - 1;
        return pageRequestDto.getSort() == null || pageRequestDto.getSort().isBlank() ?
            PageRequest.of(
                correctPage,
                pageRequestDto.getSize()
            ) :
            PageRequest.of(
                correctPage,
                pageRequestDto.getSize(),
                buildSort(pageRequestDto.getSort())
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