package br.com.kwikecommerce.api.controller.v1.product;

import br.com.kwikecommerce.api.domain.base.SortingOption;
import br.com.kwikecommerce.api.dto.product.request.ProductCreationRequest;
import br.com.kwikecommerce.api.dto.product.response.ProductListingResponseDto;
import br.com.kwikecommerce.api.service.product.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
public record ProductControllerImpl(
    ProductService productService
) implements ProductController {

    @Override
    public Long create(ProductCreationRequest request, List<MultipartFile> photos) {
        return productService.create(request, photos);
    }

    @Override
    public Page<ProductListingResponseDto> fetchPage(
        @RequestParam SortingOption sortingOption,
        @RequestParam Integer pageNumber
    ) {
        return productService.fetchPage(sortingOption, pageNumber);
    }

    @Override
    public Page<ProductListingResponseDto> fetchPageByCategory(
        @RequestParam Long categoryId,
        @RequestParam SortingOption sortingOption,
        @RequestParam Integer pageNumber
    ) {
        return productService.fetchPageByCategory(categoryId, sortingOption, pageNumber);
    }
}
