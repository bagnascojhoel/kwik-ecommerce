package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.domain.Category;
import br.com.kwikecommerce.api.domain.Product;
import br.com.kwikecommerce.api.dto.product.request.ProductCreationRequestDto;
import br.com.kwikecommerce.api.dto.product.response.ProductListingResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface ProductMapper {

    @Mapping(source = "category", target = "category")
    Product map(ProductCreationRequestDto productCreationRequestDto, Category category);

    ProductListingResponseDto map(Product product);

}
