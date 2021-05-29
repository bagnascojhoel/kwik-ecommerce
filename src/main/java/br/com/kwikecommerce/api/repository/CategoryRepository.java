package br.com.kwikecommerce.api.repository;

import br.com.kwikecommerce.api.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
