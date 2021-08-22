package br.com.kwikecommerce.api.helper;

import br.com.kwikecommerce.api.domain.ProductSorting;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;


@Component
public class ProductPaginationHelper {

    private static final int MAX_ITEMS_PER_PAGE = 20;

    public Pageable buildPageable(ProductSorting productSorting, Integer pageNumber) {
        var sort = buildSort(productSorting);
        return PageRequest.of(pageNumber, MAX_ITEMS_PER_PAGE, sort);
    }

    private Sort buildSort(ProductSorting productSorting) {
        return switch (productSorting) {
            case ALPHABETIC_DESC -> Sort.by("title").descending();
            case PRICE_ASC -> Sort.by("unitaryPrice").ascending();
            case PRICE_DESC -> Sort.by("unitaryPrice").descending();
            default -> Sort.by("title").ascending();
        };
    }

}
