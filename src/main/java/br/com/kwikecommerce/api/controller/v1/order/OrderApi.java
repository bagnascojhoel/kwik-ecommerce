package br.com.kwikecommerce.api.controller.v1.order;

import br.com.kwikecommerce.api.application.dto.request.PageRequestDto;
import br.com.kwikecommerce.api.application.dto.response.PageResponseDto;
import br.com.kwikecommerce.api.dto.request.OrderCreationRequestDto;
import br.com.kwikecommerce.api.dto.request.OrderUpdateRequestDto;
import br.com.kwikecommerce.api.dto.response.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.dto.response.OrderFindingByIdResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(
    name = "Orders",
    description = "Operations over order resources"
)
public interface OrderApi {

    @Tag(name = "Orders")
    @Operation(summary = "Creates a new Order with its items")
    Long create(OrderCreationRequestDto orderCreationRequestDto);

    @Tag(name = "Orders")
    @Operation(summary = "Find Orders valid for given filter")
    PageResponseDto<OrderFindingByFilterResponse> findByFilter(PageRequestDto pageRequestDto);

    @Tag(name = "Orders")
    void cancelById(Long orderId);

    @Tag(name = "Orders")
    OrderFindingByIdResponseDto findById(Long orderId);

    @Tag(name = "Orders")
    void update(Long orderId, OrderUpdateRequestDto orderUpdateRequestDto);

}
