package br.com.kwikecommerce.api.application.service.logging;

public interface LogService {

    void logInfo(String message);

    void logInfo(String message, Object... fields);

    void logWarning(String message);

    void logWarning(String message, Object... fields);

    void logError(String message);

    void logError(String message, Object... fields);

    void logError(String message, Throwable throwable);

}
