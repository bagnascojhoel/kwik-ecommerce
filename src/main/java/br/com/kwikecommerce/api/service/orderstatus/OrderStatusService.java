package br.com.kwikecommerce.api.service.orderstatus;

import br.com.kwikecommerce.api.domain.Order;


public interface OrderStatusService {

    void toCreatedOrder(Order order);

    void toCanceledOrder(Long orderId);

    void toDeliveredOrder(Long orderId);

}
