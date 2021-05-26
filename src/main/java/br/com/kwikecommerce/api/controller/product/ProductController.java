package br.com.kwikecommerce.api.controller.product;

import br.com.kwikecommerce.api.domain.product.SortingOption;
import br.com.kwikecommerce.api.dto.product.ProductListingDto;
import br.com.kwikecommerce.api.dto.product.creation.ProductCreationRequestDto;
import br.com.kwikecommerce.api.service.product.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/products")
public record ProductController(ProductService productService) implements ProductApi {

    @PostMapping
    public Long createProduct(@RequestBody @Validated ProductCreationRequestDto requestDto) {
        return productService.createProduct(requestDto);
    }

    @GetMapping
    public Page<ProductListingDto> listProducts(
        @RequestParam Integer pageNumber,
        @RequestParam SortingOption sortingOption) {

        return productService.listProducts(pageNumber, sortingOption);
    }

}
