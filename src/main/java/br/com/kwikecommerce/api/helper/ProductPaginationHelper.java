package br.com.kwikecommerce.api.helper;

import br.com.kwikecommerce.api.domain.base.SortingOption;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;


@Component
public class ProductPaginationHelper {

    private static final int MAX_ITEMS_PER_PAGE = 20;

    public Pageable buildPageRequest(SortingOption sortingOption, Integer pageNumber) {
        var sort = buildSort(sortingOption);
        return PageRequest.of(pageNumber, MAX_ITEMS_PER_PAGE, sort);
    }

    private Sort buildSort(SortingOption sortingOption) {
        return switch (sortingOption) {
            case ALPHABETIC_DESC -> Sort.by("title").descending();
            case PRICE_ASC -> Sort.by("unitaryPrice").ascending();
            case PRICE_DESC -> Sort.by("unitaryPrice").descending();
            default -> Sort.by("title").ascending();
        };
    }

}
