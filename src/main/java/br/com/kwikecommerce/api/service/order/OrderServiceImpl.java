package br.com.kwikecommerce.api.service.order;

import br.com.kwikecommerce.api.application.dto.request.PageRequestDto;
import br.com.kwikecommerce.api.application.dto.response.PageResponse;
import br.com.kwikecommerce.api.application.exception.base.BusinessException;
import br.com.kwikecommerce.api.application.mapper.PaginationMapper;
import br.com.kwikecommerce.api.application.util.PaginationUtil;
import br.com.kwikecommerce.api.domain.Order;
import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.dto.request.OrderUpdateRequestDto;
import br.com.kwikecommerce.api.dto.response.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.dto.response.OrderFindingByIdResponseDto;
import br.com.kwikecommerce.api.mapper.OrderMapper;
import br.com.kwikecommerce.api.message.ExceptionMessageKey;
import br.com.kwikecommerce.api.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final PaginationMapper paginationMapper;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public Order create(OrderCreationRequestDto requestDto) {
        var order = orderMapper.toOrder(requestDto);
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order update(Long orderId, OrderUpdateRequestDto request) {
        var oldOrder = orderRepository.getOne(orderId);
        var newOrder = orderMapper.toOrder(oldOrder, request);

        return orderRepository.save(newOrder);
    }

    @Override
    public OrderFindingByIdResponseDto findById(Long orderId) {
        var order = orderRepository.findById(orderId)
            .orElseThrow(() -> new BusinessException(ExceptionMessageKey.ORDER_NOT_FOUND));

        return orderMapper.toFindingByIdResponse(order);
    }

    // TODO jhoel.bagnasco 07/08/2021 | Atualizar para esperar um objeto para filtragem
    @Override
    public PageResponse<OrderFindingByFilterResponse> findByFilter(PageRequestDto pageRequestDto) {
        var page = orderRepository.findAll(PaginationUtil.buildPageable(pageRequestDto))
            .map(orderMapper::toFindingByFilterResponse);

        return paginationMapper.map(page);
    }

}
