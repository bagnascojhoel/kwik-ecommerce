package br.com.kwikecommerce.api.service.order;

import br.com.kwikecommerce.api.dto.request.OrderCreationRequest;


public interface OrderService {

    Long createOrder(OrderCreationRequest request);

}
