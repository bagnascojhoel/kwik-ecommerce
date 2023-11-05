package br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driven_ports.product;

import br.com.bagnascojhoel.kwik_ecommerce.product.domain.Product;
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductId;
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductState;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.UUID;
=======
<<<<<<< HEAD
import java.util.UUID;
=======
<<<<<<< HEAD
import java.util.UUID;
=======
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)

@Component
class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        if (rs.getString("id") == null) {
            return null;
        }

        return Product.builder()
<<<<<<< HEAD
                .id(new ProductId(UUID.fromString(rs.getString("id"))))
=======
<<<<<<< HEAD
                .id(new ProductId(UUID.fromString(rs.getString("id"))))
=======
<<<<<<< HEAD
                .id(new ProductId(UUID.fromString(rs.getString("id"))))
=======
                .id(new ProductId(rs.getString("id")))
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
                .name(rs.getString("name"))
                .description(rs.getString("description"))
                .priceInBrl(rs.getBigDecimal("price_in_brl"))
                .state(ProductState.getFromCode(rs.getString("state")))
                .imageUrl(rs.getString("image_url"))
                .build();
    }
}
