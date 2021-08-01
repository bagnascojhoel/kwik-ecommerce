package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.dto.request.OrderCreationRequest;
import br.com.kwikecommerce.api.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface OrderMapper {

    @Mapping(target = "statusHistory", ignore = true)
    Order map(OrderCreationRequest request);

}
