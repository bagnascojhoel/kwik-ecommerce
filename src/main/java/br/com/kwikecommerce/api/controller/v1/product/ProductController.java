package br.com.kwikecommerce.api.controller.v1.product;

import br.com.kwikecommerce.api.application.dto.page.PageResponseDto;
import br.com.kwikecommerce.api.application.mapper.PaginationMapper;
import br.com.kwikecommerce.api.controller.v1.product.dto.ProductCreationRequest;
import br.com.kwikecommerce.api.controller.v1.product.dto.ProductListingResponse;
import br.com.kwikecommerce.api.entity.product.ProductSortOption;
import br.com.kwikecommerce.api.mapper.ProductMapper;
import br.com.kwikecommerce.api.pagination.PageRequest;
import br.com.kwikecommerce.api.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class ProductController implements ProductApi {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final PaginationMapper paginationMapper;

    @Override
    @PostMapping
    public Long create(@RequestPart ProductCreationRequest request, @RequestPart List<MultipartFile> images) {
        var imagesUrls = productService.uploadImages(images);
        var product = productMapper.map(request, imagesUrls);
        return productService.createProduct(product);
    }

    @Override
    @GetMapping
    public PageResponseDto<ProductListingResponse> findPage(@Valid PageRequest<ProductSortOption> pageRequest) {
        var page = productService.findPage(pageRequest)
            .map(productMapper::map);

        return paginationMapper.map(page);
    }

    // TODO mover esse método para /v1/categories/{categoryId}/products
    @Override
    @GetMapping("/{categoryId}")
    public PageResponseDto<ProductListingResponse> fetchPageByCategory(
        Long categoryId,
        PageRequest<ProductSortOption> pageRequest
    ) {
        return productService.fetchPageByCategory(categoryId, pageRequest);
    }
}
