package br.com.kwikecommerce.api.application.exception;

import br.com.kwikecommerce.api.application.exception.base.BaseException;
import br.com.kwikecommerce.api.message.ExceptionMessageKey;


public class AuthenticationException extends BaseException {

    public AuthenticationException() {
        super(ExceptionMessageKey.AUTHENTICATION);
    }

}
