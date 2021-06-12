package br.com.kwikecommerce.api.controller.v1.product;

import br.com.kwikecommerce.api.domain.base.SortingOption;
import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import br.com.kwikecommerce.api.dto.response.ProductListingResponse;
import br.com.kwikecommerce.api.service.product.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
public record ProductControllerImpl(
    ProductService productService
) implements ProductController {

    @Override
    public Long create(ProductCreationRequest request, List<MultipartFile> photos) {
        return productService.createProduct(request, photos);
    }

    @Override
    public Page<ProductListingResponse> fetchPage(SortingOption sortingOption, Integer pageNumber) {
        return productService.fetchPage(sortingOption, pageNumber);
    }

    @Override
    public Page<ProductListingResponse> fetchPageByCategory(
        Long categoryId,
        SortingOption sortingOption,
        Integer pageNumber
    ) {
        return productService.fetchPageByCategory(categoryId, sortingOption, pageNumber);
    }
}
