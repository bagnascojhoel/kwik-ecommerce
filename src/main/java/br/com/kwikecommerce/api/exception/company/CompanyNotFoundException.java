package br.com.kwikecommerce.api.exception.company;

import br.com.kwikecommerce.api.application.exception.base.NotFoundException;
import br.com.kwikecommerce.api.message.ExceptionMessageKey;


public class CompanyNotFoundException extends NotFoundException {

    public CompanyNotFoundException() {
        super(ExceptionMessageKey.COMPANY_NOT_FOUND);
    }

}
