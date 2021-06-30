package br.com.kwikecommerce.api.code.application.exception;

public class PropertySettingException extends RuntimeException {

    public PropertySettingException(String propertyName) {
        super("Could not set value for property " + propertyName);
    }

}
