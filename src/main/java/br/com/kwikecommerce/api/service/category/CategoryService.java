package br.com.kwikecommerce.api.service.category;

import br.com.kwikecommerce.api.entity.Category;

import java.util.List;


public interface CategoryService {

    Long create(Category category);

    List<Category> findAll();

}
