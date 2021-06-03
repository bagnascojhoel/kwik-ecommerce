package br.com.kwikecommerce.api.service.domain.category;

import br.com.kwikecommerce.api.domain.Category;
import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequestDto;
import br.com.kwikecommerce.api.dto.category.response.CategoryListingResponseDto;

import java.util.List;


public interface CategoryService {

    Long create(CategoryCreationRequestDto categoryCreationRequestDto);

    Category fetchById(Long categoryId);

    List<CategoryListingResponseDto> fetchAll();
}
