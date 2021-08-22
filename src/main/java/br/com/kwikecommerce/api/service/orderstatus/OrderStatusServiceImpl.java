package br.com.kwikecommerce.api.service.orderstatus;

import br.com.kwikecommerce.api.domain.Order;
import br.com.kwikecommerce.api.repository.OrderStatusRepository;
import org.springframework.stereotype.Service;


@Service
public record OrderStatusServiceImpl(
    OrderStatusRepository orderStatusRepostiory
) implements OrderStatusService {

    // TODO jhoel.bagnasco 01/08/2021 | Ver como criar um repository independente de JPA para fazer queries de status

    @Override
    public void toCreatedOrder(Order order) {
        orderStatusRepostiory.toCreatedOrder(order);
    }

    @Override
    public void toCanceledOrder(Long orderId) {

    }

    @Override
    public void toDeliveredOrder(Long orderId) {

    }

}
