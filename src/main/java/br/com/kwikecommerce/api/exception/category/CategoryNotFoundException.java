package br.com.kwikecommerce.api.exception.category;

import br.com.kwikecommerce.api.application.exception.base.NotFoundException;
import br.com.kwikecommerce.api.message.ExceptionMessageKey;


public class CategoryNotFoundException extends NotFoundException {

    public CategoryNotFoundException() {
        super(ExceptionMessageKey.CATEGORY_NOT_FOUND);
    }

}
