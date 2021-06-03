package br.com.kwikecommerce.api.controller.product;

import br.com.kwikecommerce.api.domain.base.SortingOption;
import br.com.kwikecommerce.api.dto.product.request.ProductCreationRequestDto;
import br.com.kwikecommerce.api.dto.product.response.ProductListingResponseDto;
import br.com.kwikecommerce.api.service.domain.product.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/products")
public record ProductControllerImpl(
    ProductService productService
) implements ProductController {

    @Override
    @PostMapping
    public Long create(@RequestBody @Validated ProductCreationRequestDto requestDto) {
        return productService.create(requestDto);
    }

    @Override
    @GetMapping
    public Page<ProductListingResponseDto> fetchPage(
        @RequestParam SortingOption sortingOption,
        @RequestParam Integer pageNumber
    ) {
        return productService.fetchPage(sortingOption, pageNumber);
    }

    @Override
    @GetMapping("{categoryId}")
    public Page<ProductListingResponseDto> fetchPageByCategory(
        @RequestParam Long categoryId,
        @RequestParam SortingOption sortingOption,
        @RequestParam Integer pageNumber
    ) {
        return productService.fetchPageByCategory(categoryId, sortingOption, pageNumber);
    }
}
