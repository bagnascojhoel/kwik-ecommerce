package br.com.kwikecommerce.api.code.exception;

public class PropertySettingException extends RuntimeException {

    public PropertySettingException(String propertyName) {
        super("Could not set value for property " + propertyName);
    }

}
