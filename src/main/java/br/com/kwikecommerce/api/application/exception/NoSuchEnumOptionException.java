package br.com.kwikecommerce.api.application.exception;

import br.com.kwikecommerce.api.application.exception.base.BaseException;
import br.com.kwikecommerce.api.message.ExceptionMessageKey;


public class NoSuchEnumOptionException extends BaseException {

    public NoSuchEnumOptionException(String invalidEnumOption) {
        super(ExceptionMessageKey.NO_SUCH_ENUM_OPTION, invalidEnumOption);
    }

}
