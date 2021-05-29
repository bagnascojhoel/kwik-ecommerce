package br.com.kwikecommerce.api.mapper.product;

import br.com.kwikecommerce.api.domain.product.Product;
import br.com.kwikecommerce.api.dto.product.ProductListingDto;
import br.com.kwikecommerce.api.dto.product.creation.ProductCreationRequestDto;
import org.mapstruct.Mapper;


@Mapper
public interface ProductMapper extends AbstractMapper {

    Product map(ProductCreationRequestDto productCreationRequestDto);

    ProductListingDto map(Product product);

}
