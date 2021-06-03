package br.com.kwikecommerce.api.controller.category;

import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequestDto;
import br.com.kwikecommerce.api.dto.category.response.CategoryListingResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.List;


@Tags(
    @Tag(
        name = "Categories",
        description = "Operations over category resources"
    )
)
public interface CategoryController {

    @Tag(name = "Categories")
    @Operation(summary = "Creates a new category")
    Long create(CategoryCreationRequestDto categoryCreationRequestDto);

    @Tag(name = "Categories")
    @Operation(summary = "Lists all categories")
    List<CategoryListingResponseDto> fetchAll();

}
