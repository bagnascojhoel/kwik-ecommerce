package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.model.Category;
import br.com.kwikecommerce.api.dto.request.CategoryCreationRequest;
import br.com.kwikecommerce.api.dto.response.CategoryListingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(uses = CompanyMapper.class)
public interface CategoryMapper {

    @Mapping(target = "company", source = "request.companyId")
    Category map(CategoryCreationRequest request);

    CategoryListingResponse map(Category category);

    default Category mapCategoryIdToCategory(Long categoryId) {
        return Category.builder()
            .id(categoryId)
            .build();
    }

    default Long mapCategoryToCategoryId(Category category) {
        return category.getId();
    }

}
