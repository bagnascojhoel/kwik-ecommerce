package br.com.bagnascojhoel.kwik_ecommerce.product.domain;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.UUID;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
public record ProductId(@NonNull UUID rawValue) {

    public static ProductId generate() {
        return new ProductId(UUID.randomUUID());
<<<<<<< HEAD
    }

    public String toString() {
        return rawValue.toString();
=======
<<<<<<< HEAD
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
    }

    public String toString() {
        return rawValue.toString();
=======
>>>>>>> 47b2bca (feat(api): create products CRUD)
    }

    public String toString() {
        return rawValue.toString();
=======
@EqualsAndHashCode
public class ProductId {

    @NonNull
    public final UUID rawValue;

    public ProductId(@NonNull String rawValue) {
        this.rawValue = UUID.fromString(rawValue);
>>>>>>> 6b0331d (feat(api): create products CRUD)
    }

    public ProductId(@NonNull UUID rawValue) {
        this.rawValue = rawValue;
    }

    public static ProductId generate() {
        return new ProductId(UUID.randomUUID());
    }

    public String toString() {
        return rawValue.toString();
    }
}
