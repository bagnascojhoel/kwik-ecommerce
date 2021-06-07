package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.domain.Category;
import br.com.kwikecommerce.api.dto.request.CategoryCreationRequest;
import br.com.kwikecommerce.api.dto.response.CategoryListingResponse;
import org.mapstruct.Mapper;


@Mapper
public interface CategoryMapper {

    Category map(CategoryCreationRequest categoryCreationRequest);

    CategoryListingResponse map(Category category);

}
