package br.com.kwikecommerce.api.exception.base;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
    
}
