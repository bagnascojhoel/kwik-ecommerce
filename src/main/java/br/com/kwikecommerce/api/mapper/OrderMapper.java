package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.dto.response.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.model.Order;
import br.com.kwikecommerce.api.model.OrderStatus;
import br.com.kwikecommerce.api.model.PaymentMethod;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(uses = {CompanyMapper.class, OrderItemMapper.class})
public interface OrderMapper {

    @Mapping(target = "items", ignore = true)
    @Mapping(target = "statusHistory", ignore = true)
    @Mapping(target = "company", source = "companyId")
    Order map(OrderCreationRequestDto request);

    @Mapping(target = "status", source = "statusHistory")
    @Mapping(target = "paymentMethod", source = "paymentMethod")
    OrderFindingByFilterResponse map(Order order);

    default String map(PaymentMethod paymentMethod) {
        return paymentMethod.getDescription();
    }

    default String map(List<OrderStatus> statusHistory) {
        return statusHistory.get(0).getOrderStatusType().getDescription();
    }

}
