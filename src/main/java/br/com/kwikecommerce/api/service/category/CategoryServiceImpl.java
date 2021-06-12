package br.com.kwikecommerce.api.service.category;

import br.com.kwikecommerce.api.application.service.message.MessageService;
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
    CategoryRepository categoryRepository,
    MessageService messageService
) implements CategoryService {

    @Override
    public Long create(CategoryCreationRequest categoryCreationRequest) {
        var category = categoryMapper.map(categoryCreationRequest);
        return categoryRepository.save(category).getId();
    }

    @Override
    public List<CategoryListingResponse> fetchAll() {
        return categoryRepository.findAll().stream()
            .map(categoryMapper::map)
            .collect(Collectors.toList());
    }

}
