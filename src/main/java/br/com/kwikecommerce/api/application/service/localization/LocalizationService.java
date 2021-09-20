package br.com.kwikecommerce.api.application.service.localization;

import br.com.kwikecommerce.api.message.MessageKey;


public interface LocalizationService {

    String fetch(MessageKey messageKey);

    String fetch(MessageKey messageKey, Object... fields);

    String fetch(String messageKey);

    String fetch(String messageKey, Object... fields);

}
