package br.com.kwikecommerce.api.service.order;

import br.com.kwikecommerce.api.application.dto.request.PageRequest;
import br.com.kwikecommerce.api.application.dto.response.PageResponse;
import br.com.kwikecommerce.api.domain.Order;
import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.dto.request.OrderUpdateRequestDto;
import br.com.kwikecommerce.api.dto.response.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.dto.response.OrderFindingByIdResponseDto;


public interface OrderService {

    Order create(OrderCreationRequestDto request);

    Order update(Long orderId, OrderUpdateRequestDto request);

    PageResponse<OrderFindingByFilterResponse> findByFilter(PageRequest pageRequest);

    OrderFindingByIdResponseDto findById(Long orderId);

}
