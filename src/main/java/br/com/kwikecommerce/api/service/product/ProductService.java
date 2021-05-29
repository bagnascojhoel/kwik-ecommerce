package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.domain.general.SortingOption;
import br.com.kwikecommerce.api.dto.product.request.ProductCreationRequestDto;
import br.com.kwikecommerce.api.dto.product.response.ProductListingResponseDto;
import org.springframework.data.domain.Page;


public interface ProductService {

    Long create(ProductCreationRequestDto productCreationRequestDto);

    Page<ProductListingResponseDto> fetchPage(Integer pageNumber, SortingOption sortingOption);

}
