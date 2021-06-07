package br.com.kwikecommerce.api.exception.base;

import br.com.kwikecommerce.api.message.MessageKey;


public class BusinessException extends BaseException {

    public BusinessException(MessageKey messageKey) {
        super(messageKey);
    }

    public BusinessException(MessageKey messageKey, Object... fields) {
        super(messageKey, fields);
    }

}
