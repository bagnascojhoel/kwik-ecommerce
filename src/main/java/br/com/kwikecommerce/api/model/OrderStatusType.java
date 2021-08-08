package br.com.kwikecommerce.api.model;

import br.com.kwikecommerce.api.application.exception.NoSuchEnumOptionException;
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

    private final String description;

    public static OrderStatusType discoverByDescription(String description) {
        for (var orderStatusType : values()) {
            if (orderStatusType.getDescription().equalsIgnoreCase(description))
                return orderStatusType;
        }

        throw new NoSuchEnumOptionException(description);
    }

}
