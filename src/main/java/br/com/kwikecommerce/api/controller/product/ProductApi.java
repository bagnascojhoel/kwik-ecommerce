package br.com.kwikecommerce.api.controller.product;

import br.com.kwikecommerce.api.domain.product.SortingOption;
import br.com.kwikecommerce.api.dto.product.ProductListingDto;
import br.com.kwikecommerce.api.dto.product.creation.ProductCreationRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;


@Api(value = "/products", tags = "Products")
public interface ProductApi {

    @ApiOperation("Creates a new product")
    Long createProduct(ProductCreationRequestDto requestDto);

    @ApiOperation("Fetches a page of products")
    Page<ProductListingDto> listProducts(

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
