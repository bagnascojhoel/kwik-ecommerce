package br.com.kwikecommerce.api.controller.v1.order;

import br.com.kwikecommerce.api.application.dto.request.PageRequestDto;
import br.com.kwikecommerce.api.application.dto.response.PageResponseDto;
import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.dto.request.OrderUpdateRequestDto;
import br.com.kwikecommerce.api.dto.response.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.dto.response.OrderFindingByIdResponseDto;
import br.com.kwikecommerce.api.validator.order.OrderExists;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;


@Tag(
    name = "Orders",
    description = "Operations over order resources"
)
public interface OrderApi {

    @Tag(name = "Orders")
    @Operation(summary = "Initiates an order with its items")
    Long init(@Valid OrderCreationRequestDto orderCreationRequestDto);

    @Tag(name = "Orders")
    void cancel(Long orderId);

    @Tag(name = "Orders")
    @Operation(summary = "Find Orders valid for given filter")
    PageResponseDto<OrderFindingByFilterResponse> findByFilter(PageRequestDto pageRequestDto);

    @Tag(name = "Orders")
    OrderFindingByIdResponseDto findById(@OrderExists Long orderId);

    // TODO jhoel.bagnasco 22/08/2021 | Alterar padrão de nomes para verbos no infinitivo
    @Tag(name = "Orders")
    @Operation(summary = "Updates an order")
    void update(@OrderExists Long orderId, @Valid OrderUpdateRequestDto orderUpdateRequestDto);

}
