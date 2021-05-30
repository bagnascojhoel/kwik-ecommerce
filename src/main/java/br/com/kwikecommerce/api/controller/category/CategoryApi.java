package br.com.kwikecommerce.api.controller.category;

import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "Categories", tags = "Categories")
public interface CategoryApi {

    @ApiOperation(value = "Creates a new category", tags = "Categories")
    Long create(CategoryCreationRequestDto categoryCreationRequestDto);

}
