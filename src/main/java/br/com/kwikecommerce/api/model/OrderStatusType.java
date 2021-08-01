package br.com.kwikecommerce.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum OrderStatusType {
    PENDING("PENDENTE"),
    VIEWED("VISUALIZADO"),
    ON_GOING("EM ANDAMENTO"),
    CANCELED("CANCELADO"),
    SENT("ENVIADO"),
    DELIVERED("ENTREGUE");

    private final String name;

}
