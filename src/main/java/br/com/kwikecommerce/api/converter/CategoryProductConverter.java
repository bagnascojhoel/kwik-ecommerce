package br.com.kwikecommerce.api.converter;

import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequestDto;
import br.com.kwikecommerce.api.dto.product.request.ProductCreationRequestDto;
import org.mapstruct.Mapper;


@Mapper
public interface CategoryProductConverter {

    CategoryCreationRequestDto map(ProductCreationRequestDto productCreationRequestDto);

}
