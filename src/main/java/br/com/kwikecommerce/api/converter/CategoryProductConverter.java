package br.com.kwikecommerce.api.converter;

import br.com.kwikecommerce.api.dto.request.CategoryCreationRequest;
import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import org.mapstruct.Mapper;


@Mapper
public interface CategoryProductConverter {

    CategoryCreationRequest map(ProductCreationRequest productCreationRequest);

}
