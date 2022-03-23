package br.com.kwikecommerce.api.controller.category;

import br.com.kwikecommerce.api.controller.category.dto.CategoryListingResponse;
import br.com.kwikecommerce.api.controller.category.dto.CategoryCreationRequestDto;
import br.com.kwikecommerce.api.category.CategoryMapper;
import br.com.kwikecommerce.api.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/categories")
public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Override
    @PostMapping
    public Long create(CategoryCreationRequestDto categoryCreationRequestDto) {
        var category = categoryMapper.map(categoryCreationRequestDto);
        return categoryService.create(category);
    }

    @Override
    @GetMapping
    public List<CategoryListingResponse> listAll() {
        var categories = categoryService.findAll();
        return categories.stream()
            .map(categoryMapper::map)
            .toList();
    }

}
