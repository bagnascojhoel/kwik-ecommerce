package br.com.kwikecommerce.api.application.configuration;

import br.com.kwikecommerce.api.application.common.Constants;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class MessageSourceConfiguration {

    private static final String ENCODING = "UTF-8";
    private static final String[] MESSAGE_SOURCES = {"messages", "messages-exception", "messages-validation"};

    @Bean
    public LocalValidatorFactoryBean validator() {
        var validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource());
        return validator;
    }

    @Bean
    public MessageSource messageSource() {
        var messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames(MESSAGE_SOURCES);
        messageSource.setDefaultEncoding(ENCODING);
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        var localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Constants.LOCALE_PT_BR);
        return localeResolver;
    }

}
