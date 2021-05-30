package br.com.kwikecommerce.api.controller.product;

import br.com.kwikecommerce.api.domain.base.SortingOption;
import br.com.kwikecommerce.api.dto.product.request.ProductCreationRequestDto;
import br.com.kwikecommerce.api.dto.product.response.ProductListingResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;


@Api(value = "Products", tags = "Products")
public interface ProductApi {

    @ApiOperation(value = "Creates a new product", tags = "Products")
    Long create(ProductCreationRequestDto requestDto);

    @ApiOperation(value = "Fetches a page of products", tags = "Products")
    Page<ProductListingResponseDto> list(
        @ApiParam(
            value = "Page number (first page is 0)",
            example = "1"
        ) Integer pageNumber,
        @ApiParam(
            value = "Sorting option",
            example = "ALPHABETIC_DESC"
        ) SortingOption sortingOption
    );

}
