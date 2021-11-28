package br.com.kwikecommerce.api.service.category;

import br.com.kwikecommerce.api.dto.request.CategoryCreationRequest;
import br.com.kwikecommerce.api.dto.response.CategoryListingResponse;

import java.util.List;


public interface CategoryService {

    void create(CategoryCreationRequest categoryCreationRequest);

    List<CategoryListingResponse> fetchAll();

}
