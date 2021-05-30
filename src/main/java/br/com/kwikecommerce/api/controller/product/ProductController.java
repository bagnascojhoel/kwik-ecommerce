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
public record ProductController(
    ProductService productService
) implements ProductApi {

    @Override
    @PostMapping
    public Long create(@RequestBody @Validated ProductCreationRequestDto requestDto) {
        return productService.create(requestDto);
    }

    @Override
    @GetMapping
    public Page<ProductListingResponseDto> list(
        @RequestParam Integer pageNumber,
        @RequestParam SortingOption sortingOption) {

        return productService.fetchPage(pageNumber, sortingOption);
    }

}
