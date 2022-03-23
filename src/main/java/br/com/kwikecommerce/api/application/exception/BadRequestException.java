package br.com.kwikecommerce.api.application.exception;

import br.com.kwikecommerce.api.message.MessageProperty;
import lombok.Getter;


@Getter
public class BadRequestException extends BaseException {

    public BadRequestException(MessageProperty messageProperty) {
        super(messageProperty);
    }

}
