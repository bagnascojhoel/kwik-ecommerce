package br.com.kwikecommerce.kwikecommerceapi.repository;

import br.com.kwikecommerce.kwikecommerceapi.domain.product.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
