package br.com.bagnascojhoel.kwik_ecommerce.product.domain;

import lombok.NonNull;

import java.util.UUID;

public record ProductId(@NonNull String rawValue) {

    public static ProductId generate() {
        return new ProductId(UUID.randomUUID().toString());
    }

}
