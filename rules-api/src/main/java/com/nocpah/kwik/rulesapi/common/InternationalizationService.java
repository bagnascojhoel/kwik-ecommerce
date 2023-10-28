package com.nocpah.kwik.rulesapi.common;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Slf4j
@RequiredArgsConstructor
public class InternationalizationService {
    private static final String DEFAULT_MESSAGE = "Unexpected error";

    private final MessageSource messageSource;

    public String get(ErrorCode errorCode, Object... arguments) {
        try {
            return this.messageSource.getMessage(errorCode.getMessageCode(), arguments, Locale.getDefault());
        } catch (NoSuchMessageException noSuchMessageException) {
            var message = "key=no-such-message,message-code=%s,message-args=%s".formatted(errorCode, arguments);
            log.error(message, noSuchMessageException);
            return DEFAULT_MESSAGE;
        }
    }
}
