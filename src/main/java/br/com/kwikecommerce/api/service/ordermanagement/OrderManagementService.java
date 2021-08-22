package br.com.kwikecommerce.api.service.ordermanagement;

import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.model.Order;


public interface OrderManagementService {

    Order createOrder(OrderCreationRequestDto requestDto);

}
