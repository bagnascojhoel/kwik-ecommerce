package br.com.kwikecommerce.api.service.order;

import br.com.kwikecommerce.api.application.dto.request.PageRequestDto;
import br.com.kwikecommerce.api.application.util.PaginationUtil;
import br.com.kwikecommerce.api.dto.request.OrderCreationRequest;
import br.com.kwikecommerce.api.dto.response.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.mapper.OrderMapper;
import br.com.kwikecommerce.api.repository.OrderRepository;
import br.com.kwikecommerce.api.service.orderstatus.OrderStatusService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public record OrderServiceImpl(
    OrderRepository orderRepository,
    OrderMapper orderMapper,
    OrderStatusService orderStatusService
) implements OrderService {

    @Override
    public Long create(OrderCreationRequest request) {
        // TODO: 12/07/2021 Validar request antes de salvar
        var order = orderMapper.map(request);
        var savedOrder = orderRepository.save(order);
        orderStatusService.toCreatedOrder(savedOrder);

        return savedOrder.getId();
    }

    // TODO jhoel.bagnasco 07/08/2021 | Atualizar para esperar um objeto para filtragem
    @Override
    public Page<OrderFindingByFilterResponse> findByFilter(PageRequestDto pageRequestDto) {
        return orderRepository.findAll(PaginationUtil.buildPageable(pageRequestDto))
            .map(orderMapper::map);
    }

}
