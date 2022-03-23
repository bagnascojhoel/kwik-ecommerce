package br.com.kwikecommerce.api.application.exception;

public class NoSuchEnumOptionException extends Exception {

    public NoSuchEnumOptionException(String invalidEnumOption) {
        super(invalidEnumOption);
    }

}
