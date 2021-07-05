package br.com.kwikecommerce.api.code.exception;

public class UnknownTypeException extends RuntimeException {

    public UnknownTypeException(String typeName) {
        super("Could not handle unknown type " + typeName);
    }

}
