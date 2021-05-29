package br.com.kwikecommerce.api.mapper.product;

import org.mapstruct.factory.Mappers;


public interface AbstractMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

}
