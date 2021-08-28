package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.domain.Order;
import br.com.kwikecommerce.api.domain.OrderItem;
import br.com.kwikecommerce.api.domain.OrderStatus;
import br.com.kwikecommerce.api.domain.PaymentMethod;
import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.dto.request.OrderUpdateRequestDto;
import br.com.kwikecommerce.api.dto.response.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.dto.response.OrderFindingByIdResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static java.util.Objects.nonNull;


@Mapper(uses = {CompanyMapper.class, OrderItemMapper.class, OrderStatusMapper.class})
public interface OrderMapper {

    @Mapping(target = "items", ignore = true)
    @Mapping(target = "statusHistory", ignore = true)
    @Mapping(target = "company", source = "companyId")
    Order toOrder(OrderCreationRequestDto request);

    @Mapping(target = "status", source = "statusHistory")
    OrderFindingByFilterResponse toFindingByFilterResponse(Order order);

    default Order toOrder(Order oldOrder, OrderUpdateRequestDto request) {
        if (nonNull(request.getPaymentMethod()))
            oldOrder.setPaymentMethod(request.getPaymentMethod());

        if (nonNull(request.getFreightPrice()))
            oldOrder.setFreightPrice(request.getFreightPrice());

        return oldOrder;
    }

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
