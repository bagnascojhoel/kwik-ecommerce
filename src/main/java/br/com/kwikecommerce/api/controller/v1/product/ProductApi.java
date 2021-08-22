package br.com.kwikecommerce.api.controller.v1.product;

import br.com.kwikecommerce.api.model.ProductSorting;
import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import br.com.kwikecommerce.api.dto.response.ProductListingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;


@Tag(
    name = "Products",
    description = "Operations over product resources"
)
public interface ProductApi {

    @Tag(name = "Products")
    @Operation(
        summary = "Create a new product",
        description = """
            On Swagger this endpoint doesn't work correctly. Please, use an API Client which
            supports file upload via Multipart Form Data (e.g. Postman).
            """
    )
    Long create(
        @RequestPart @Valid ProductCreationRequest request,
        @RequestPart List<MultipartFile> images
    );

    @Tag(name = "Products")
    @Operation(summary = "Fetch a page of products")
    @Parameter(name = "sortingOption")
    @Parameter(name = "pageNumber", example = "0")
    Page<ProductListingResponse> fetchPage(
        @RequestParam ProductSorting productSorting,
        @RequestParam Integer pageNumber
    );

    @Tag(name = "Products")
    @Operation(summary = "Fetch a page of products from a given category")
    @Parameter(name = "categoryId", in = ParameterIn.PATH, example = "1")
    @Parameter(name = "sortingOption")
    @Parameter(name = "pageNumber", example = "0")
    Page<ProductListingResponse> fetchPageByCategory(
        @PathVariable Long categoryId,
        @RequestParam ProductSorting productSorting,
        @RequestParam Integer pageNumber
    );

}
