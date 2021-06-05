package br.com.kwikecommerce.api.service.category;

import br.com.kwikecommerce.api.domain.Category;
import br.com.kwikecommerce.api.dto.category.request.CategoryCreationRequest;
import br.com.kwikecommerce.api.dto.category.response.CategoryListingResponse;

import java.util.List;


public interface CategoryService {

    Long create(CategoryCreationRequest categoryCreationRequest);

    Category fetchById(Long categoryId);

    List<CategoryListingResponse> fetchAll();
}
