package br.com.kwikecommerce.api.repository;

import br.com.kwikecommerce.api.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByCategories_id(Long categoryId, Pageable pageable);

}
