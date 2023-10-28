package br.com.bagnascojhoel.kwik_ecommerce.product.domain;

import br.com.bagnascojhoel.kwik_ecommerce.common.domain.AbstractResourceNotFound;

public class ProductNotFound extends AbstractResourceNotFound {
    public ProductNotFound() {
        super("product-not-found");
    }
}
