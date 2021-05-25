package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.domain.product.SortingOption;
import br.com.kwikecommerce.api.dto.product.ProductListingDto;
import br.com.kwikecommerce.api.dto.product.creation.ProductCreationRequestDto;
import org.springframework.data.domain.Page;

public interface ProductService {

    Long createProduct(ProductCreationRequestDto productCreationRequestDto);

    Page<ProductListingDto> listProducts(Integer pageNumber, SortingOption sortingOption);

}
