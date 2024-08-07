package br.com.bagnascojhoel.kwik_ecommerce.product.driving_infra.rest;

import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

@Tags({
        @Tag(name = "/management"),
        @Tag(
                name = "/management/products",
                description = "Full management capabilities of products"
        )
})
public interface ManagementProductRestApi {

    @Operation(summary = "Create a product")
    ProductDto postProducts(
            final ProductDto productDto
    );

    @Operation(summary = "Gets all products")
    ProductCollectionDto getProducts();

    @Operation(summary = "Gets a single product by its ID")
    ProductDto getProduct(final ProductId productId);

    @Operation(summary = "Updates the state of a product")
    void putState(
            @Schema(type = "string") final ProductId productId,
            final ProductDto productDto
    );
}
