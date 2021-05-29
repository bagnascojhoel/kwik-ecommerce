package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.domain.Product;
import br.com.kwikecommerce.api.dto.product.request.ProductCreationRequestDto;
import br.com.kwikecommerce.api.dto.product.response.ProductListingResponseDto;
import org.mapstruct.Mapper;


@Mapper
public interface ProductMapper {

    Product map(ProductCreationRequestDto productCreationRequestDto);

    ProductListingResponseDto map(Product product);

}
