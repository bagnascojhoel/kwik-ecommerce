package br.com.kwikecommerce.api.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum PaymentMethod implements DomainType {
    PIX("PIX"),
    CREDIT_CARD("CARTÃO DE CRÉDITO"),
    DEBIT_CARD("CARTÃO DE DÉBITO"),
    OTHER("OUTRO");

    @Getter
    private final String description;

}
