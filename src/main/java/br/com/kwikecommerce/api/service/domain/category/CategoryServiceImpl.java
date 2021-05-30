package br.com.kwikecommerce.api.service.domain.category;

import br.com.kwikecommerce.api.domain.Category;
import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequestDto;
import br.com.kwikecommerce.api.exceptions.category.CategoryNotFoundException;
import br.com.kwikecommerce.api.mapper.CategoryMapper;
import br.com.kwikecommerce.api.repository.CategoryRepository;
import br.com.kwikecommerce.api.service.application.LocalizationService;
import org.springframework.stereotype.Service;


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
}
