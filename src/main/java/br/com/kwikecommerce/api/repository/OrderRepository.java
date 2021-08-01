package br.com.kwikecommerce.api.repository;

import br.com.kwikecommerce.api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
