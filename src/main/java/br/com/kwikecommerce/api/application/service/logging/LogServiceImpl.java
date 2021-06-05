package br.com.kwikecommerce.api.application.service.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public record LogServiceImpl() implements LogService {

    @Override
    public void logInfo(String message) {
        log.info(message);
    }

    @Override
    public void logInfo(String message, Object... fields) {
        log.info(message, fields);
    }

    @Override
    public void logWarning(String message) {
        log.warn(message);
    }

    @Override
    public void logWarning(String message, Object... fields) {
        log.warn(message, fields);
    }

    @Override
    public void logError(String message) {
        log.error(message);
    }

    @Override
    public void logError(String message, Object... fields) {
        log.error(message, fields);
    }

    @Override
    public void logError(String message, Throwable throwable) {
        log.error(message, throwable);
    }
}
