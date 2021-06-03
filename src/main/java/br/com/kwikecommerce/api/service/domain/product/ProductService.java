package br.com.kwikecommerce.api.service.domain.product;

import br.com.kwikecommerce.api.domain.base.SortingOption;
import br.com.kwikecommerce.api.dto.product.request.ProductCreationRequestDto;
import br.com.kwikecommerce.api.dto.product.response.ProductListingResponseDto;
import org.springframework.data.domain.Page;


public interface ProductService {

    Long create(ProductCreationRequestDto productCreationRequestDto);

    Page<ProductListingResponseDto> fetchPage(SortingOption sortingOption, Integer pageNumber);

    Page<ProductListingResponseDto> fetchPageByCategory(
        Long categoryId,
        SortingOption sortingOption,
        Integer pageNumber
    );

}
