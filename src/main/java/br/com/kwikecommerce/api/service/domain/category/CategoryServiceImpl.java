package br.com.kwikecommerce.api.service.domain.category;

import br.com.kwikecommerce.api.domain.Category;
import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequestDto;
import br.com.kwikecommerce.api.dto.category.response.CategoryListingResponseDto;
import br.com.kwikecommerce.api.exception.category.CategoryNotFoundException;
import br.com.kwikecommerce.api.mapper.CategoryMapper;
import br.com.kwikecommerce.api.repository.CategoryRepository;
import br.com.kwikecommerce.api.service.application.LocalizationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public record CategoryServiceImpl(
    CategoryMapper categoryMapper,
    CategoryRepository categoryRepository,
    LocalizationService localizationService
) implements CategoryService {

    @Override
    public Long create(CategoryCreationRequestDto categoryCreationRequestDto) {
        var category = categoryMapper.map(categoryCreationRequestDto);
        return categoryRepository.save(category).getId();
    }

    @Override
    public Category fetchById(Long categoryId) {
        return categoryRepository.findById(categoryId)
            .orElseThrow(() -> new CategoryNotFoundException("categoria não encontrada"));
    }

    @Override
    public List<CategoryListingResponseDto> fetchAll() {
        return categoryRepository.findAll().stream()
            .map(categoryMapper::map)
            .collect(Collectors.toList());
    }

}
