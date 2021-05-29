package br.com.kwikecommerce.api.controller.category;

import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequestDto;
import br.com.kwikecommerce.api.service.category.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/categories")
public record CategoryControllerImpl(
    CategoryService categoryService
) implements CategoryController {

    @Override
    public Long create(CategoryCreationRequestDto categoryCreationRequestDto) {
        return categoryService.create(categoryCreationRequestDto);
    }

}
