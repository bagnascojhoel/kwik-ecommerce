package br.com.kwikecommerce.api.exception.category;

import br.com.kwikecommerce.api.exception.base.NotFoundException;


public class CategoryNotFoundException extends NotFoundException {

    public CategoryNotFoundException(String message) {
        super(message);
    }

}
