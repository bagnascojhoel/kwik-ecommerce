package br.com.kwikecommerce.api.application.exception;

import br.com.kwikecommerce.api.message.MessageProperty;


public class FileException extends BaseException {

    public FileException(MessageProperty messageProperty) {
        super(messageProperty);
    }

}
