package br.com.kwikecommerce.api.application.service.message;

import br.com.kwikecommerce.api.message.MessageKey;


public interface MessageService {

    String fetch(MessageKey messageKey);

    String fetch(MessageKey messageKey, Object... fields);

}
