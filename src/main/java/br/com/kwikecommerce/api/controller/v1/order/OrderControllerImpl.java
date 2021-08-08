package br.com.kwikecommerce.api.controller.v1.order;

import br.com.kwikecommerce.api.application.dto.request.PageRequestDto;
import br.com.kwikecommerce.api.dto.request.OrderCreationRequest;
import br.com.kwikecommerce.api.dto.response.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.service.order.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/orders")
public record OrderControllerImpl(
    OrderService orderService
) implements OrderController {

    @Override
    @PostMapping
    public Long create(@RequestBody OrderCreationRequest orderCreationRequest) {
        return orderService.create(orderCreationRequest);
    }

    @Override
    @GetMapping
    public Page<OrderFindingByFilterResponse> findByFilter(PageRequestDto pageRequestDto) {
        return orderService.findByFilter(pageRequestDto);
    }

}
