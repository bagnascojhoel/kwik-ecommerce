package br.com.kwikecommerce.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum PaymentMethod {
    PIX("PIX"),
    CREDIT_CARD("CARTÃO DE CRÉDITO"),
    DEBIT_CARD("CARTÃO DE DÉBITO"),
    OTHER("OUTRO");

    @Getter
    private final String description;

}
