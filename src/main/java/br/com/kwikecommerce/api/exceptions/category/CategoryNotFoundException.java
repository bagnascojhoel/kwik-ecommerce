package br.com.kwikecommerce.api.exceptions.category;

import br.com.kwikecommerce.api.exceptions.base.NotFoundException;


public class CategoryNotFoundException extends NotFoundException {

    public CategoryNotFoundException(String message) {
        super(message);
    }

}
