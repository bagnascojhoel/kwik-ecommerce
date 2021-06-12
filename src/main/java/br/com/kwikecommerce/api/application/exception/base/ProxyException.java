package br.com.kwikecommerce.api.application.exception.base;

import br.com.kwikecommerce.api.message.MessageKey;


public class ProxyException extends BaseException {

    public ProxyException(MessageKey messageKey) {
        super(messageKey);
    }

    public ProxyException(MessageKey messageKey, Object... fields) {
        super(messageKey, fields);
    }
    
}
