package br.com.kwikecommerce.api.service.ordermanagement;

import br.com.kwikecommerce.api.entity.Company;
import br.com.kwikecommerce.api.entity.order.Order;


public interface OrderManagementService {

    Order create(Company company, Order order);

    void cancel(Long orderId);

}
