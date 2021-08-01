package br.com.kwikecommerce.api.service.order;

import br.com.kwikecommerce.api.dto.request.OrderCreationRequest;
import br.com.kwikecommerce.api.mapper.OrderMapper;
import br.com.kwikecommerce.api.repository.OrderRepository;
import br.com.kwikecommerce.api.service.orderstatus.OrderStatusService;


public record OrderServiceImpl(
    OrderRepository orderRepository,
    OrderMapper orderMapper,
    OrderStatusService orderStatusService
) implements OrderService {

    @Override
    public Long createOrder(OrderCreationRequest request) {
        // TODO: 12/07/2021 Validar request antes de salvar
        var order = orderMapper.map(request);
        var savedOrder = orderRepository.save(order);
        orderStatusService.toCreatedOrder(savedOrder);

        return savedOrder.getId();
    }

}
