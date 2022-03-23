package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.controller.v1.order.dto.OrderCreationRequestDto;
import br.com.kwikecommerce.api.controller.v1.order.dto.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.controller.v1.order.dto.OrderFindingByIdResponseDto;
import br.com.kwikecommerce.api.entity.PaymentMethod;
import br.com.kwikecommerce.api.entity.order.Order;
import br.com.kwikecommerce.api.entity.order.OrderItem;
import br.com.kwikecommerce.api.entity.order.OrderStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.List;


@Mapper(uses = {CompanyMapper.class, OrderItemMapper.class, OrderStatusMapper.class})
public interface OrderMapper {

    @Mapping(target = "items", ignore = true)
    @Mapping(target = "statusHistory", ignore = true)
    @Mapping(target = "company", source = "companyId")
    Order toOrder(OrderCreationRequestDto request);

    @Mapping(target = "status", source = "statusHistory")
    OrderFindingByFilterResponse toFindingByFilterResponse(Order order);

    Order toOrder(Order oldOrder, PaymentMethod paymentMethod, BigDecimal freightPrice);

    @Mapping(target = "status", expression = "java(toOrderFindingByIdResponseOrderStatus(order.getStatusHistory().get(0)))")
    OrderFindingByIdResponseDto toFindingByIdResponse(Order order);

    @Mapping(target = "changedAt", source = "createdAt")
    OrderFindingByIdResponseDto.OrderStatus toOrderFindingByIdResponseOrderStatus(OrderStatus orderStatus);

    OrderFindingByIdResponseDto.OrderItem toOrderFindingByIdResponseOrderItem(OrderItem orderItem);

    default String map(PaymentMethod paymentMethod) {
        return paymentMethod.getDescription();
    }

    default String map(List<OrderStatus> statusHistory) {
        return statusHistory.get(0).getType().getDescription();
    }

}
