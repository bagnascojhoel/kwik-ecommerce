package br.com.kwikecommerce.api.service.ordermanagement;

import br.com.kwikecommerce.api.domain.Order;
import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;


public interface OrderManagementService {

    Order init(OrderCreationRequestDto requestDto);

    void cancel(Long orderId);

}
