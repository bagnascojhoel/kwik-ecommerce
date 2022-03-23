package br.com.kwikecommerce.api.category;

import br.com.kwikecommerce.api.controller.category.dto.CategoryCreationRequestDto;
import br.com.kwikecommerce.api.controller.product.dto.ProductCreationRequest;
import org.mapstruct.Mapper;


@Mapper
public interface CategoryProductMapper {

    CategoryCreationRequestDto map(ProductCreationRequest productCreationRequest);

}
