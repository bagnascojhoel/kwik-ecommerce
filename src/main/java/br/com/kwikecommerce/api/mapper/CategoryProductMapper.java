package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.dto.request.CategoryCreationRequest;
import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import org.mapstruct.Mapper;


@Mapper
public interface CategoryProductMapper {

    CategoryCreationRequest map(ProductCreationRequest productCreationRequest);

}
