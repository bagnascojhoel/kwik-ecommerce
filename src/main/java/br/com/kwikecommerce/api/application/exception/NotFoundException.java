package br.com.kwikecommerce.api.application.exception;


import br.com.kwikecommerce.api.message.MessageProperty;


public class NotFoundException extends BaseException {

    public NotFoundException(MessageProperty messageProperty) {
        super(messageProperty);
    }

}
