package br.com.kwikecommerce.api.service.ordermanagement;

import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.model.Order;
import br.com.kwikecommerce.api.service.order.OrderService;
import br.com.kwikecommerce.api.service.orderitem.OrderItemService;
import br.com.kwikecommerce.api.service.orderstatus.OrderStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderManagementServiceImpl implements OrderManagementService {

    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final OrderStatusService orderStatusService;

    @Override
    public Order createOrder(OrderCreationRequestDto requestDto) {
        var order = orderService.create(requestDto);
        orderItemService.create(requestDto.getItems(), order.getId());
        orderStatusService.toCreatedOrder(order);

        return order;
    }

}
