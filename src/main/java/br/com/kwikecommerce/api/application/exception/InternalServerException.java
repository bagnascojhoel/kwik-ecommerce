package br.com.kwikecommerce.api.application.exception;

import br.com.kwikecommerce.api.message.MessageProperty;
import lombok.Getter;


public class InternalServerException extends BaseException {

    @Getter
    private final MessageProperty logMessage;

    public InternalServerException(MessageProperty logMessage) {
        super(MessageProperty.of("e.unknown"));

        this.logMessage = logMessage;
    }

    public InternalServerException(
        MessageProperty clientMessage,
        MessageProperty logMessage
    ) {
        super(clientMessage);
        this.logMessage = logMessage;
    }

}
