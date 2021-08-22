package br.com.kwikecommerce.api.repository;

import br.com.kwikecommerce.api.domain.Order;


public interface OrderStatusRepository {

    void toCreatedOrder(Order order);

    void toCanceledOrder(Order order, String reason);

}
