package br.com.kwikecommerce.api.service.orderstatus;

import br.com.kwikecommerce.api.model.Order;


public interface OrderStatusService {

    void toCreatedOrder(Order savedOrder);

    void toCanceledOrder(Long orderId);

    void toDeliveredOrder(Long orderId);

}
