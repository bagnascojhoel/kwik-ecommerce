package br.com.kwikecommerce.api.application.exception;

import br.com.kwikecommerce.api.message.MessageProperty;


public abstract class BaseException extends RuntimeException {

    private MessageProperty clientMessage;

    public BaseException(MessageProperty clientMessage) {
        this.clientMessage = clientMessage;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public MessageProperty getTextForClient() {
        return this.clientMessage;
    }

}
