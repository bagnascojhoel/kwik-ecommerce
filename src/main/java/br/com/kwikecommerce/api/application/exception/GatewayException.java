package br.com.kwikecommerce.api.application.exception;

import br.com.kwikecommerce.api.message.MessageProperty;


public class GatewayException extends BaseException {

    public GatewayException(MessageProperty messageProperty) {
        super(messageProperty);
    }

}
