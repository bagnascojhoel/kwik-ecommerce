package br.com.kwikecommerce.api.controller.product;

import br.com.kwikecommerce.api.domain.base.SortingOption;
import br.com.kwikecommerce.api.dto.product.request.ProductCreationRequestDto;
import br.com.kwikecommerce.api.dto.product.response.ProductListingResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.data.domain.Page;


@Tags({
    @Tag(
        name = "Products",
        description = "Operations over product resources"
    )
})
public interface ProductController {

    @Tag(name = "Products")
    @Operation(summary = "Creates a new product")
    Long create(ProductCreationRequestDto requestDto);

    @Tag(name = "Products")
    @Operation(summary = "Fetches a page of products")
    @Parameters({
        @Parameter(
            name = "Sorting Option",
            ref = "SortingOption"
        ),
        @Parameter(
            name = "Page number",
            example = "1"
        )
    })
    Page<ProductListingResponseDto> fetchPage(SortingOption sortingOption, Integer pageNumber);

    @Tag(name = "Products")
    @Operation(summary = "Fetches a page of products from the same category")
    @Parameters({
        @Parameter(name = "Category Id", example = "1"),
        @Parameter(name = "Sorting Option", ref = "Sorting Option"),
        @Parameter(name = "Page number", example = "1")
    })
    Page<ProductListingResponseDto> fetchPageByCategory(
        Long categoryId,
        SortingOption sortingOption,
        Integer pageNumber
    );

}
