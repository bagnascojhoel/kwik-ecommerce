package br.com.kwikecommerce.api.controller.category;

import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequestDto;
import io.swagger.annotations.Api;


@Api(value = "/categories", tags = "Categories")
public interface CategoryController {

    Long create(CategoryCreationRequestDto categoryCreationRequestDto);

}
