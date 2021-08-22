package br.com.kwikecommerce.api.service.orderitem;

import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.domain.OrderItem;

import java.util.List;


public interface OrderItemService {

    List<OrderItem> create(
        List<OrderCreationRequestDto.OrderItem> items,
        Long orderId
    );

}
