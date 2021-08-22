package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.domain.Order;
import br.com.kwikecommerce.api.domain.OrderStatus;
import br.com.kwikecommerce.api.domain.PaymentMethod;
import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.dto.request.OrderUpdateRequestDto;
import br.com.kwikecommerce.api.dto.response.OrderFindingByFilterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static java.util.Objects.nonNull;


@Mapper(uses = {CompanyMapper.class, OrderItemMapper.class})
public interface OrderMapper {

    @Mapping(target = "items", ignore = true)
    @Mapping(target = "statusHistory", ignore = true)
    @Mapping(target = "company", source = "companyId")
    Order map(OrderCreationRequestDto request);

    @Mapping(target = "status", source = "statusHistory")
    OrderFindingByFilterResponse map(Order order);

    default Order map(Order oldOrder, OrderUpdateRequestDto request) {
        if (nonNull(request.getPaymentMethod()))
            oldOrder.setPaymentMethod(request.getPaymentMethod());

        if (nonNull(request.getFreightPrice()))
            oldOrder.setFreightPrice(request.getFreightPrice());

        return oldOrder;
    }

    default String map(PaymentMethod paymentMethod) {
        return paymentMethod.getDescription();
    }

    default String map(List<OrderStatus> statusHistory) {
        return statusHistory.get(0).getOrderStatusType().getDescription();
    }


}
