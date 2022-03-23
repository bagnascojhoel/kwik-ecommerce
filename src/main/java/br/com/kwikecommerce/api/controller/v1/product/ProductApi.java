package br.com.kwikecommerce.api.controller.v1.product;

import br.com.kwikecommerce.api.application.dto.page.PageResponseDto;
import br.com.kwikecommerce.api.controller.v1.product.dto.ProductCreationRequest;
import br.com.kwikecommerce.api.controller.v1.product.dto.ProductListingResponse;
import br.com.kwikecommerce.api.entity.Product;
import br.com.kwikecommerce.api.pagination.PageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;


@Tag(
    name = "Product",
    description = "Operations over product resources"
)
public interface ProductApi {

    @Tag(name = "Products")
    @Operation(
        summary = "Create",
        description = """
            On Swagger this endpoint doesn't work correctly. Please, use an API Client which
            supports file upload via Multipart Form Data (e.g. Postman).
            """
    )
    Long create(@Valid ProductCreationRequest request, List<MultipartFile> images);

    @Tag(name = "Products")
    @Operation(summary = "Find page")
    PageResponseDto<ProductListingResponse> findPage(
        @Valid PageRequest<Product.ProductSortOption> pageRequest
    );

    @Tag(name = "Products")
    @Operation(summary = "Fetch a page of products from a given category")
    @Parameter(name = "categoryId", in = ParameterIn.PATH, example = "1")
    @Parameter(name = "sortingOption")
    @Parameter(name = "pageNumber", example = "0")
    PageResponseDto<ProductListingResponse> fetchPageByCategory(
        @PathVariable Long categoryId,
        PageRequest<Product.ProductSortOption> pageRequest
    );

}
