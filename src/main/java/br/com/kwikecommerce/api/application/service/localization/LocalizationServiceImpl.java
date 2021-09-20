package br.com.kwikecommerce.api.application.service.localization;

import br.com.kwikecommerce.api.message.MessageKey;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;


@Service
public record LocalizationServiceImpl(
    MessageSource messageSource
) implements LocalizationService {

    @Override
    public String fetch(MessageKey messageKey) {
        return messageSource.getMessage(messageKey.getKey(), null, LocaleContextHolder.getLocale());
    }

    @Override
    public String fetch(MessageKey messageKey, Object... fields) {
        return messageSource.getMessage(messageKey.getKey(), fields, LocaleContextHolder.getLocale());
    }

    @Override
    public String fetch(String messageKey) {
        return messageSource.getMessage(messageKey, null, LocaleContextHolder.getLocale());
    }

    @Override
    public String fetch(String messageKey, Object... fields) {
        return messageSource.getMessage(messageKey, fields, LocaleContextHolder.getLocale());
    }

}
