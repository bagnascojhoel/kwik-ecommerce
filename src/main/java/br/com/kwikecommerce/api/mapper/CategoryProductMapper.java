package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.controller.v1.category.dto.CategoryCreationRequestDto;
import br.com.kwikecommerce.api.controller.v1.product.dto.ProductCreationRequest;
import org.mapstruct.Mapper;


@Mapper
public interface CategoryProductMapper {

    CategoryCreationRequestDto map(ProductCreationRequest productCreationRequest);

}
