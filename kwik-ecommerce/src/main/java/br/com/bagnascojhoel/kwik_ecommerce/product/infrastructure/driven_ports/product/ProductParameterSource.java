package br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driven_ports.product;

import br.com.bagnascojhoel.kwik_ecommerce.product.domain.Product;
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductId;
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductState;
import lombok.NonNull;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
class ProductParameterSource {
    public SqlParameterSource forUpsert(@NonNull final Product product) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
<<<<<<< HEAD
        parameters.addValue("id", product.getId().rawValue());
=======
<<<<<<< HEAD
        parameters.addValue("id", product.getId().rawValue());
=======
<<<<<<< HEAD
        parameters.addValue("id", product.getId().rawValue());
=======
        parameters.addValue("id", product.getId().rawValue);
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
        parameters.addValue("name", product.getName());
        parameters.addValue("description", product.getDescription());
        parameters.addValue("price_in_brl", product.getPriceInBrl());
        parameters.addValue("state", product.getState().getCode());
        parameters.addValue("image_url", product.getImageUrl());
        // TODO Grab the audit data from the context
        parameters.addValue("created_by", "bagnascojhoel");
        parameters.addValue("created_at", OffsetDateTime.now());
        parameters.addValue("modified_by", "bagnascojhoel");
        parameters.addValue("modified_at", OffsetDateTime.now());
        return parameters;
    }

    public SqlParameterSource onlyId(@NonNull final ProductId productId) {
<<<<<<< HEAD
        return new MapSqlParameterSource("id", productId.rawValue());
=======
<<<<<<< HEAD
        return new MapSqlParameterSource("id", productId.rawValue());
=======
<<<<<<< HEAD
        return new MapSqlParameterSource("id", productId.rawValue());
=======
        return new MapSqlParameterSource("id", productId.rawValue);
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
    }

    public SqlParameterSource onlyState(@NonNull final ProductState productState) {
        return new MapSqlParameterSource("state", productState.getCode());
    }
}
