package br.com.kwikecommerce.api.service.category;

import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequestDto;


public interface CategoryService {

    Long create(CategoryCreationRequestDto categoryCreationRequestDto);

}
