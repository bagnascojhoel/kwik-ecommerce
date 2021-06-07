package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.domain.Category;
import br.com.kwikecommerce.api.domain.Product;
import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import br.com.kwikecommerce.api.dto.response.ProductListingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper
public interface ProductMapper {

    @Mapping(source = "photos", target = "photosUrls")
    @Mapping(source = "category", target = "category")
    Product map(
        ProductCreationRequest productCreationRequest,
        Category category,
        List<String> photos
    );

    @Mapping(source = "category.id", target = "categoryId")
    ProductListingResponse map(Product product);

}
