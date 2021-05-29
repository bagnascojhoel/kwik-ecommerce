package br.com.kwikecommerce.api.service.category;

import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequestDto;
import br.com.kwikecommerce.api.mapper.CategoryMapper;
import br.com.kwikecommerce.api.repository.CategoryRepository;
import org.springframework.stereotype.Service;


@Service
public record CategoryServiceImpl(
    CategoryMapper categoryMapper,
    CategoryRepository categoryRepository
) implements CategoryService {

    @Override
    public Long create(CategoryCreationRequestDto categoryCreationRequestDto) {
        var category = categoryMapper.map(categoryCreationRequestDto);
        return categoryRepository.save(category).getId();
    }

}
