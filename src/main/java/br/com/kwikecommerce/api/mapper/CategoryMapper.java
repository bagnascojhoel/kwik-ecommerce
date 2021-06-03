package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.domain.Category;
import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequestDto;
import br.com.kwikecommerce.api.dto.category.response.CategoryListingResponseDto;
import org.mapstruct.Mapper;


@Mapper
public interface CategoryMapper {

    Category map(CategoryCreationRequestDto categoryCreationRequestDto);

    CategoryListingResponseDto map(Category category);

}
