package br.com.kwikecommerce.api.repository;

import br.com.kwikecommerce.api.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
