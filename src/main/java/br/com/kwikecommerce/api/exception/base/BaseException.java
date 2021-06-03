package br.com.kwikecommerce.api.exception.base;

import br.com.kwikecommerce.api.message.MessageKey;
import lombok.Getter;


@Getter
public class BaseException extends RuntimeException {

    private final MessageKey messageKey;
    private final Object[] fields;

    public BaseException(MessageKey messageKey) {
        this.messageKey = messageKey;
        this.fields = null;
    }

    public BaseException(MessageKey messageKey, Object... fields) {
        this.messageKey = messageKey;
        this.fields = fields;
    }

}
