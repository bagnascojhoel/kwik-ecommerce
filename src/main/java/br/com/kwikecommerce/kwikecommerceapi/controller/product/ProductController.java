package br.com.kwikecommerce.kwikecommerceapi.controller.product;

import br.com.kwikecommerce.kwikecommerceapi.domain.product.SortingOption;
import br.com.kwikecommerce.kwikecommerceapi.dto.product.ProductListingDto;
import br.com.kwikecommerce.kwikecommerceapi.dto.product.creation.ProductCreationRequestDto;
import br.com.kwikecommerce.kwikecommerceapi.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Long createProduct(@RequestBody @Validated ProductCreationRequestDto requestDto) {
        return productService.createProduct(requestDto);
    }

    @GetMapping
    public Page<ProductListingDto> listProducts(@RequestParam Integer pageNumber, @RequestParam SortingOption sortingOption) {
        return productService.listProducts(pageNumber, sortingOption);
    }

}
