package br.com.kwikecommerce.api.mapper.product;

import br.com.kwikecommerce.api.domain.product.Product;
import br.com.kwikecommerce.api.dto.product.ProductListingDto;
import br.com.kwikecommerce.api.dto.product.creation.ProductCreationRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product map(ProductCreationRequestDto dto) {
        return Product.builder()
            .title(dto.getTitle())
            .availableQty(dto.getAvailableQty())
            .description(dto.getDescription())
            .unitaryPrice(dto.getUnitaryPrice())
            .build();
    }

    public Page<ProductListingDto> map(Page<Product> pages) {
        return pages.map(this::map);
    }

    public ProductListingDto map(Product model) {
        return ProductListingDto.builder()
            .title(model.getTitle())
            .description(model.getDescription())
            .unitaryPrice(model.getUnitaryPrice())
            .availableQty(model.getAvailableQty())
            .build();
    }

}
