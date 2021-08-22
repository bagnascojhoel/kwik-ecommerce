package br.com.kwikecommerce.api.controller.v1.order;

import br.com.kwikecommerce.api.application.dto.request.PageRequestDto;
import br.com.kwikecommerce.api.application.dto.response.PageResponseDto;
import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.dto.request.OrderUpdateRequestDto;
import br.com.kwikecommerce.api.dto.response.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.dto.response.OrderFindingByIdResponseDto;
import br.com.kwikecommerce.api.service.order.OrderService;
import br.com.kwikecommerce.api.service.ordermanagement.OrderManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
public class OrderController implements OrderApi {

    private final OrderService orderService;
    private final OrderManagementService orderManagementService;

    @Override
    @PostMapping
    public Long init(@RequestBody @Valid OrderCreationRequestDto orderCreationRequestDto) {
        return orderManagementService.init(orderCreationRequestDto).getId();
    }

    @Override
    @GetMapping
    public PageResponseDto<OrderFindingByFilterResponse> findByFilter(PageRequestDto pageRequestDto) {
        return orderService.findByFilter(pageRequestDto);
    }

    @Override

    public void cancel(Long orderId) {
        // TODO implement
    }

    @Override
    @GetMapping("/{orderId}")
    public OrderFindingByIdResponseDto findById(@PathVariable Long orderId) {
        return orderService.findById(orderId);
    }

    @Override
    @PutMapping("/{orderId}")
    public void update(@PathVariable Long orderId, @RequestBody OrderUpdateRequestDto orderUpdateRequestDto) {
        orderService.update(orderId, orderUpdateRequestDto);
    }

}
