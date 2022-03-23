package br.com.kwikecommerce.api.repository;

import br.com.kwikecommerce.api.entity.order.Order;
import br.com.kwikecommerce.api.entity.order.OrderStatus;
import br.com.kwikecommerce.api.entity.order.OrderStatusType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@RequiredArgsConstructor
@Repository
public class OrderStatusRepositoryImpl implements OrderStatusRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    @Transactional
    public void toCreatedOrder(Order order) {
        OrderStatus orderStatus = OrderStatus.builder()
            .type(OrderStatusType.PENDING)
            .order(order)
            .build();

        entityManager.persist(orderStatus);
    }

    @Override
    public void toCanceledOrder(Order order, String reason) {

    }

}
