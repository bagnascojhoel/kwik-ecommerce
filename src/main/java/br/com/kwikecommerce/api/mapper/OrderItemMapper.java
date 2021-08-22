package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.model.Order;
import br.com.kwikecommerce.api.model.OrderItem;
import br.com.kwikecommerce.api.model.Product;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper
public interface OrderItemMapper {

    @Mapping(target = "order", ignore = true)
    List<OrderItem> map(List<OrderCreationRequestDto.OrderItem> items, @Context Long orderId);

    default OrderItem map(OrderCreationRequestDto.OrderItem item, @Context Long orderId) {
        var order = Order.builder()
            .id(orderId)
            .build();

        var product = Product.builder()
            .id(item.getProductId())
            .build();

        return OrderItem.builder()
            .order(order)
            .product(product)
            .quantity(item.getQuantity())
            .unitarySalePrice(item.getUnitarySalePrice())
            .description(item.getDescription())
            .build();
    }

}
