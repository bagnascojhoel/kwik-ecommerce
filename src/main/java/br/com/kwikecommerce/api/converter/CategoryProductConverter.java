package br.com.kwikecommerce.api.converter;

import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequest;
import br.com.kwikecommerce.api.dto.product.request.ProductCreationRequest;
import org.mapstruct.Mapper;


@Mapper
public interface CategoryProductConverter {

    CategoryCreationRequest map(ProductCreationRequest productCreationRequest);

}
