package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.controller.v1.product.dto.ProductCreationRequest;
import br.com.kwikecommerce.api.controller.v1.product.dto.ProductListingResponse;
import br.com.kwikecommerce.api.entity.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(uses = {CategoryMapper.class, CompanyMapper.class})
public interface ProductMapper {

    @Mapping(target = "imagesUrls", source = "imagesUrls")
    @Mapping(target = "categories", source = "request.categoriesIds")
    @Mapping(target = "company", source = "request.companyId")
    Product map(ProductCreationRequest request, List<String> imagesUrls);

    @Mapping(target = "categoriesIds", source = "categories")
    ProductListingResponse map(Product product);

}
