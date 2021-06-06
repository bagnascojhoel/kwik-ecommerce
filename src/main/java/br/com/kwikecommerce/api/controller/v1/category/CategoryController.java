package br.com.kwikecommerce.api.controller.v1.category;

import br.com.kwikecommerce.api.dto.request.CategoryCreationRequest;
import br.com.kwikecommerce.api.dto.response.CategoryListingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@Tag(
    name = "Categories",
    description = "Operations over category resources"
)
@RequestMapping("/v1/categories")
public interface CategoryController {

    @Tag(name = "Categories")
    @PostMapping
    @Operation(summary = "Create a new category")
    Long create(@RequestBody @Valid CategoryCreationRequest categoryCreationRequest);

    @Tag(name = "Categories")
    @GetMapping
    @Operation(summary = "List all categories")
    List<CategoryListingResponse> fetchAll();

}
