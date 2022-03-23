package br.com.kwikecommerce.api.controller.v1.order;

import br.com.kwikecommerce.api.pagination.PageRequest;
import br.com.kwikecommerce.api.application.dto.page.PageResponseDto;
import br.com.kwikecommerce.api.controller.v1.order.dto.OrderCreationRequestDto;
import br.com.kwikecommerce.api.controller.v1.order.dto.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.controller.v1.order.dto.OrderFindingByIdResponseDto;
import br.com.kwikecommerce.api.controller.v1.order.dto.OrderUpdateRequestDto;
import br.com.kwikecommerce.api.validator.order.OrderExists;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Tag(
    name = "Orders",
    description = "Operations over order resources"
)
public interface OrderApi {

    // TODO jhoel.bagnasco 22/08/2021 | Alterar padrão de nomes para verbos no infinitivo
    @Tag(name = "Orders")
    @Operation(summary = "Initiates an order with its items")
    Long init(@NotNull Long companyId, @Valid OrderCreationRequestDto orderCreationRequestDto);

    @Tag(name = "Orders")
    @Operation(summary = "Updates an order")
    void update(@OrderExists Long orderId, @Valid OrderUpdateRequestDto orderUpdateRequestDto);

    @Tag(name = "Orders")
    void cancel(Long orderId);

    @Tag(name = "Orders")
    @Operation(summary = "Finds orders valid for given filter")
    PageResponseDto<OrderFindingByFilterResponse> findByFilter(PageRequest pageRequest);

    @Tag(name = "Orders")
    @Operation(summary = "Finds an order by its ID")
    OrderFindingByIdResponseDto findById(@OrderExists Long orderId);


}
