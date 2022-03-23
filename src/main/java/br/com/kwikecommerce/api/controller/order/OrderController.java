package br.com.kwikecommerce.api.controller.order;

import br.com.kwikecommerce.api.application.pagination.PageResponseDto;
import br.com.kwikecommerce.api.controller.order.dto.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.controller.order.dto.OrderFindingByIdResponseDto;
import br.com.kwikecommerce.api.controller.order.dto.OrderCreationRequestDto;
import br.com.kwikecommerce.api.controller.order.dto.OrderUpdateRequestDto;
import br.com.kwikecommerce.api.order.OrderManagementMapper;
import br.com.kwikecommerce.api.application.pagination.PageRequest;
import br.com.kwikecommerce.api.order.OrderService;
import br.com.kwikecommerce.api.order.OrderManagementService;
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
    private final OrderManagementMapper orderManagementMapper;

    // TODO jhoel.bagnasco | Adicionar endpoint de exclusão de item de pedido
    // TODO jhoel.bagnasco | Adicionar testes
    // TODO jhoel.bagnasco | Adicionar autenticação com o Google

    @Override
    @PostMapping
    public Long init(
        @RequestHeader("companyId") Long companyId,
        @RequestBody @Valid OrderCreationRequestDto orderCreationRequestDto
    ) {
        return null;
    }

    @Override
    @GetMapping
    public PageResponseDto<OrderFindingByFilterResponse> findByFilter(PageRequest pageRequest) {
        return orderService.findByFilter(pageRequest);
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
        orderService.update(
            orderId,
            orderUpdateRequestDto.getPaymentMethod(),
            orderUpdateRequestDto.getFreightPrice()
        );
    }

}
