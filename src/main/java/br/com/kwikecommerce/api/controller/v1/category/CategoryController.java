package br.com.kwikecommerce.api.controller.v1.category;

import br.com.kwikecommerce.api.dto.request.CategoryCreationRequest;
import br.com.kwikecommerce.api.dto.response.CategoryListingResponse;
import br.com.kwikecommerce.api.service.category.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1/categories")
public record CategoryController(
    CategoryService categoryService
) implements CategoryApi {

    @Override
    @PostMapping
    public Long create(CategoryCreationRequest categoryCreationRequest) {
        return categoryService.create(categoryCreationRequest);
    }

    @Override
    @GetMapping
    public List<CategoryListingResponse> fetchAll() {
        return categoryService.fetchAll();
    }

}
