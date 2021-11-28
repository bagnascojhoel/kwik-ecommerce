package br.com.kwikecommerce.api.service.category;

import br.com.kwikecommerce.api.dto.request.CategoryCreationRequest;
import br.com.kwikecommerce.api.dto.response.CategoryListingResponse;
import br.com.kwikecommerce.api.mapper.CategoryMapper;
import br.com.kwikecommerce.api.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public record CategoryServiceImpl(
    CategoryMapper categoryMapper,
    CategoryRepository categoryRepository
) implements CategoryService {

    @Override
    public void create(CategoryCreationRequest categoryCreationRequest) {
        var category = categoryMapper.map(categoryCreationRequest);
        categoryRepository.save(category).getId();
    }

    @Override
    public List<CategoryListingResponse> fetchAll() {
        return categoryRepository.findAll().stream()
            .map(categoryMapper::map)
            .collect(Collectors.toList());
    }

}
