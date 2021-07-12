package br.com.kwikecommerce.api.repository;

import br.com.kwikecommerce.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    Long countByIdIn(Collection<Long> categoriesIds);

}
