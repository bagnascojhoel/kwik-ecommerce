package br.com.kwikecommerce.api.controller.v1.product;

import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import br.com.kwikecommerce.api.dto.response.ProductListingResponse;
import br.com.kwikecommerce.api.model.ProductSorting;
import br.com.kwikecommerce.api.service.product.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/v1/products")
public record ProductController(
    ProductService productService
) implements ProductApi {

    @Override
    @PostMapping
    public Long create(ProductCreationRequest request, List<MultipartFile> images) {
        return productService.createProduct(request, images);
    }

    @Override
    @GetMapping
    public Page<ProductListingResponse> fetchPage(ProductSorting productSorting, Integer pageNumber) {
        return productService.fetchPage(productSorting, pageNumber);
    }

    @Override
    @GetMapping("/{categoryId}")
    public Page<ProductListingResponse> fetchPageByCategory(
        Long categoryId,
        ProductSorting productSorting,
        Integer pageNumber
    ) {
        return productService.fetchPageByCategory(categoryId, productSorting, pageNumber);
    }
}
