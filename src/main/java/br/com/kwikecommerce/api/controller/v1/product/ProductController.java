package br.com.kwikecommerce.api.controller.v1.product;

import br.com.kwikecommerce.api.domain.base.SortingOption;
import br.com.kwikecommerce.api.dto.product.request.ProductCreationRequest;
import br.com.kwikecommerce.api.dto.product.response.ProductListingResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;


@Tags({
    @Tag(
        name = "Products",
        description = "Operations over product resources"
    )
})
@RequestMapping("/v1/products")
public interface ProductController {

    @Tag(name = "Products")
    @Operation(summary = "Creates a new product")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Long create(
        @RequestPart @Valid ProductCreationRequest request,
        @RequestPart List<MultipartFile> photos
    );

    @Tag(name = "Products")
    @Operation(summary = "Fetches a page of products")
    @GetMapping
    @Parameters({
        @Parameter(name = "Sorting Option"),
        @Parameter(name = "Page number", example = "1")
    })
    Page<ProductListingResponseDto> fetchPage(SortingOption sortingOption, Integer pageNumber);

    @Tag(name = "Products")
    @Operation(summary = "Fetches a page of products from the same category")
    @GetMapping("{categoryId}")
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
