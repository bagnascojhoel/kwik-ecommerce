package br.com.kwikecommerce.api.controller.category;

import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequestDto;
import br.com.kwikecommerce.api.dto.category.response.CategoryListingResponseDto;
import br.com.kwikecommerce.api.service.domain.category.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/categories")
public record CategoryControllerImpl(
    CategoryService categoryService
) implements CategoryController {

    @Override
    @PostMapping
    public Long create(@RequestBody CategoryCreationRequestDto categoryCreationRequestDto) {
        return categoryService.create(categoryCreationRequestDto);
    }

    @Override
    @GetMapping
    public List<CategoryListingResponseDto> fetchAll() {
        return categoryService.fetchAll();
    }

}
