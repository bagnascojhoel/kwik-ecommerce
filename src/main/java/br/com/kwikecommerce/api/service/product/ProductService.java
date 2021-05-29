package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.domain.SortingOption;
import br.com.kwikecommerce.api.dto.product.response.ProductListingResponseDto;
import br.com.kwikecommerce.api.dto.product.request.ProductCreationRequestDto;
import org.springframework.data.domain.Page;

public interface ProductService {

    Long createProduct(ProductCreationRequestDto productCreationRequestDto);

    Page<ProductListingResponseDto> listProducts(Integer pageNumber, SortingOption sortingOption);

}
