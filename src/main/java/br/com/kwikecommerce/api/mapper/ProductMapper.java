package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.model.Product;
import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import br.com.kwikecommerce.api.dto.response.ProductListingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(uses = {CategoryMapper.class, CompanyMapper.class})
public interface ProductMapper {

    @Mapping(target = "imagesUrls", source = "photos")
    @Mapping(target = "categories", source = "request.categoriesIds")
    @Mapping(target = "company", source = "request.companyId")
    Product map(
        ProductCreationRequest request,
        List<String> photos
    );

    @Mapping(target = "categoriesIds", source = "categories")
    ProductListingResponse map(Product product);

}
