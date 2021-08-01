package br.com.kwikecommerce.api.repository;

import br.com.kwikecommerce.api.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StatusRepository extends JpaRepository<OrderStatus, Long> {
}
