package br.com.kwikecommerce.api.converter;

import br.com.kwikecommerce.api.model.OrderStatusType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter
public class OrderStatusTypeConverter implements AttributeConverter<OrderStatusType, String> {

    @Override
    public String convertToDatabaseColumn(OrderStatusType orderStatusType) {
        return orderStatusType.getDescription();
    }

    @Override
    public OrderStatusType convertToEntityAttribute(String aString) {
        return OrderStatusType.discoverByDescription(aString);
    }

}
