package br.com.kwikecommerce.api.service.order;

import br.com.kwikecommerce.api.application.dto.request.PageRequestDto;
import br.com.kwikecommerce.api.application.dto.response.PageResponseDto;
import br.com.kwikecommerce.api.application.mapper.PaginationMapper;
import br.com.kwikecommerce.api.application.util.PaginationUtil;
import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.dto.response.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.mapper.OrderMapper;
import br.com.kwikecommerce.api.model.Order;
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
        var order = orderMapper.map(requestDto);
        return orderRepository.save(order);
    }

    // TODO jhoel.bagnasco 07/08/2021 | Atualizar para esperar um objeto para filtragem
    @Override
    public PageResponseDto<OrderFindingByFilterResponse> findByFilter(PageRequestDto pageRequestDto) {
        var page = orderRepository.findAll(PaginationUtil.buildPageable(pageRequestDto))
            .map(orderMapper::map);

        return paginationMapper.map(page);
    }

}
