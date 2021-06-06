package br.com.kwikecommerce.api.controller.v1.category;

import br.com.kwikecommerce.api.dto.request.CategoryCreationRequest;
import br.com.kwikecommerce.api.dto.response.CategoryListingResponse;
import br.com.kwikecommerce.api.service.category.CategoryService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public record CategoryControllerImpl(
    CategoryService categoryService
) implements CategoryController {

    @Override
    public Long create(CategoryCreationRequest categoryCreationRequest) {
        return categoryService.create(categoryCreationRequest);
    }

    @Override
    public List<CategoryListingResponse> fetchAll() {
        return categoryService.fetchAll();
    }

}
