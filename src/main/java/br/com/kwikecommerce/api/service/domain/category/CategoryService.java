package br.com.kwikecommerce.api.service.domain.category;

import br.com.kwikecommerce.api.domain.Category;
import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequestDto;


public interface CategoryService {

    Long create(CategoryCreationRequestDto categoryCreationRequestDto);

    Category fetchById(Long categoryId);

}
