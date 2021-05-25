package br.com.kwikecommerce.api.repository;

import br.com.kwikecommerce.api.domain.product.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
