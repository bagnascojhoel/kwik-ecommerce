package br.com.kwikecommerce.api.repository;

import br.com.kwikecommerce.api.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StatusRepository extends JpaRepository<OrderStatus, Long> {
}
