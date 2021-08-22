package br.com.kwikecommerce.api.service.orderitem;

import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.mapper.OrderItemMapper;
import br.com.kwikecommerce.api.model.OrderItem;
import br.com.kwikecommerce.api.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItem> create(List<OrderCreationRequestDto.OrderItem> items, Long orderId) {
        List<OrderItem> orderItems = orderItemMapper.map(items, orderId);

        return orderItemRepository.saveAll(orderItems);
    }

}
