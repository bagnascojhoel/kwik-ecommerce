package br.com.kwikecommerce.api.controller.category;

import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequestDto;
import br.com.kwikecommerce.api.service.domain.category.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/categories")
public record CategoryController(
    CategoryService categoryService
) implements CategoryApi {

    @Override
    @PostMapping
    public Long create(@RequestBody CategoryCreationRequestDto categoryCreationRequestDto) {
        return categoryService.create(categoryCreationRequestDto);
    }

}
