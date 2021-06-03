package br.com.kwikecommerce.api.service.application.message;

import br.com.kwikecommerce.api.message.MessageKey;


public interface MessageService {

    String fetch(MessageKey messageKey);

    String fetch(MessageKey messageKey, Object... fields);

}
