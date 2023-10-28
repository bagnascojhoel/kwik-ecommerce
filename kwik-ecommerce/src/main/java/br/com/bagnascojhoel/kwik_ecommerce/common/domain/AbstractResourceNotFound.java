package br.com.bagnascojhoel.kwik_ecommerce.common.domain;

import lombok.Getter;

@Getter
public class AbstractResourceNotFound extends RuntimeException {

    private final String messageCode;

    public AbstractResourceNotFound(String messageCode) {
        super(messageCode);
        this.messageCode = messageCode;
    }

}
