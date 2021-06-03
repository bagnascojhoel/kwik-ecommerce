package br.com.kwikecommerce.api.exception.base;

import br.com.kwikecommerce.api.message.MessageKey;


public class NotFoundException extends BaseException {

    public NotFoundException(MessageKey messageKey) {
        super(messageKey);
    }

    public NotFoundException(MessageKey messageKey, Object... fields) {
        super(messageKey, fields);
    }

}
