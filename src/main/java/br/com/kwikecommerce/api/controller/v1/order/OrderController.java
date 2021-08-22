package br.com.kwikecommerce.api.controller.v1.order;

import br.com.kwikecommerce.api.application.dto.request.PageRequestDto;
import br.com.kwikecommerce.api.application.dto.response.PageResponseDto;
import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.dto.request.OrderUpdateRequestDto;
import br.com.kwikecommerce.api.dto.response.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.dto.response.OrderFindingByIdResponseDto;
import br.com.kwikecommerce.api.service.order.OrderService;
import br.com.kwikecommerce.api.service.ordermanagement.OrderManagementService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/v1/orders")
public record OrderController(
    OrderService orderService,
    OrderManagementService orderManagementService
) implements OrderApi {

    @Override
    @PostMapping
    public Long create(@RequestBody @Valid OrderCreationRequestDto orderCreationRequestDto) {
        return orderManagementService.createOrder(orderCreationRequestDto).getId();
    }

    @Override
    @GetMapping
    public PageResponseDto<OrderFindingByFilterResponse> findByFilter(PageRequestDto pageRequestDto) {
        return orderService.findByFilter(pageRequestDto);
    }

    @Override
    public void cancelById(Long orderId) {
        // TODO implement
    }

    @Override
    public OrderFindingByIdResponseDto findById(Long orderId) {
        // TODO implement
        return null;
    }

    @Override
    public void update(Long orderId, OrderUpdateRequestDto orderUpdateRequestDto) {
        return;
    }

}
