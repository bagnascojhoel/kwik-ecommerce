package br.com.kwikecommerce.kwikecommerceapi.service.product;

import br.com.kwikecommerce.kwikecommerceapi.domain.product.SortingOption;
import br.com.kwikecommerce.kwikecommerceapi.dto.product.ProductListingDto;
import br.com.kwikecommerce.kwikecommerceapi.dto.product.creation.ProductCreationRequestDto;
import org.springframework.data.domain.Page;

public interface ProductService {

    Long createProduct(ProductCreationRequestDto productCreationRequestDto);

    Page<ProductListingDto> listProducts(Integer pageNumber, SortingOption sortingOption);

}
