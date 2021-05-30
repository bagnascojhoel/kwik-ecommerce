package br.com.kwikecommerce.api.exceptions.base;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
    
}
