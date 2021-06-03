package br.com.kwikecommerce.api.service.application.message;

import br.com.kwikecommerce.api.message.MessageKey;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;


@Service
public record MessageServiceImpl(
    MessageSource messageSource
) implements MessageService {

    @Override
    public String fetch(MessageKey messageKey) {
        return messageSource.getMessage(messageKey.getKey(), null, LocaleContextHolder.getLocale());
    }

    @Override
    public String fetch(MessageKey messageKey, Object... fields) {
        return messageSource.getMessage(messageKey.getKey(), fields, LocaleContextHolder.getLocale());
    }

}
