package br.com.bagnascojhoel.kwik_ecommerce.product.domain;

import lombok.*;

import java.math.BigDecimal;

import static br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductState.*;

@Data
@RequiredArgsConstructor
@Builder(toBuilder = true)
@NonNull
public final class Product {

    @Builder.Default
    private final ProductId id = ProductId.generate();

    @Builder.Default
    @Getter(AccessLevel.NONE)
    private final ProductState state = HIDDEN;

    private final String name;

    private final String description;

    private final BigDecimal priceInBrl;

    private final String imageUrl;

    public boolean canBeShownToCustomer() {
        return SHOWN.equals(this.state);
    }

    public boolean isArchived() {
        return ARCHIVED.equals(this.state);
    }

    public Product archive() {
        return toBuilder().state(ARCHIVED).build();
    }

    public Product hide() {
        return toBuilder().state(HIDDEN).build();
    }

    public Product show() {
        return toBuilder().state(SHOWN).build();
    }

    public boolean isOnState(@NonNull final ProductState productState) {
        return this.state.equals(productState);
    }
}
