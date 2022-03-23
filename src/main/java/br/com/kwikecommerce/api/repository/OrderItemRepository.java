package br.com.kwikecommerce.api.repository;

import br.com.kwikecommerce.api.entity.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
