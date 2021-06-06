package br.com.kwikecommerce.api.controller.v1.category;

import br.com.kwikecommerce.api.dto.request.CategoryCreationRequest;
import br.com.kwikecommerce.api.dto.response.CategoryListingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Tag(
    name = "Categories",
    description = "Operations over category resources"
)
@RequestMapping("/v1/categories")
public interface CategoryController {

    @Tag(name = "Categories")
    @Operation(summary = "Creates a new category")
    @PostMapping
    Long create(@RequestBody CategoryCreationRequest categoryCreationRequest);

    @Tag(name = "Categories")
    @Operation(summary = "Lists all categories")
    @GetMapping
    List<CategoryListingResponse> fetchAll();

}
