package br.com.kwikecommerce.api.controller.v1.product;

import br.com.kwikecommerce.api.domain.base.SortingOption;
import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import br.com.kwikecommerce.api.dto.response.ProductListingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;


@Tag(
    name = "Products",
    description = "Operations over product resources"
)
@RequestMapping("/v1/products")
public interface ProductController {

    @Tag(name = "Products")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Create a new product")
    Long create(
        @RequestPart @Valid ProductCreationRequest request,
        @RequestPart List<MultipartFile> photos
    );

    @Tag(name = "Products")
    @GetMapping
    @Operation(summary = "Fetch a page of products")
    @Parameters({
        @Parameter(name = "sortingOption"),
        @Parameter(name = "pageNumber", example = "0")
    })
    Page<ProductListingResponse> fetchPage(
        @RequestParam SortingOption sortingOption,
        @RequestParam Integer pageNumber
    );

    @Tag(name = "Products")
    @GetMapping("/{categoryId}")
    @Operation(summary = "Fetch a page of products from a given category")
    @Parameters({
        @Parameter(name = "categoryId", in = ParameterIn.PATH, example = "1"),
        @Parameter(name = "sortingOption"),
        @Parameter(name = "pageNumber", example = "0")
    })
    Page<ProductListingResponse> fetchPageByCategory(
        @PathVariable Long categoryId,
        @RequestParam SortingOption sortingOption,
        @RequestParam Integer pageNumber
    );

}
