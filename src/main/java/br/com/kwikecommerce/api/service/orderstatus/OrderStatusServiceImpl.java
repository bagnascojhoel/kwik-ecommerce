package br.com.kwikecommerce.api.service.orderstatus;

import br.com.kwikecommerce.api.model.Order;


public record OrderStatusServiceImpl(

) implements OrderStatusService {

    @Override
    public void toCreatedOrder(Order savedOrder) {

    }

    @Override
    public void toCanceledOrder(Long orderId) {

    }

    @Override
    public void toDeliveredOrder(Long orderId) {

    }

}
