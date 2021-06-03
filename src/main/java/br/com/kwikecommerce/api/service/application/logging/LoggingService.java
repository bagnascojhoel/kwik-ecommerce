package br.com.kwikecommerce.api.service.application.logging;

public interface LoggingService {

    void logInfo(String message);

    void logWarning(String message);

    void logError(String message);

    void logInfo(String message, Object... fields);

    void logWarning(String message, Object... fields);

    void logError(String message, Object... fields);

}
