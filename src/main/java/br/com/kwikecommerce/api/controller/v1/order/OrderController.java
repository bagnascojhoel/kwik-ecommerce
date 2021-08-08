package br.com.kwikecommerce.api.controller.v1.order;

import br.com.kwikecommerce.api.application.dto.request.PageRequestDto;
import br.com.kwikecommerce.api.dto.request.OrderCreationRequest;
import br.com.kwikecommerce.api.dto.response.OrderFindingByFilterResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;


@Tag(
    name = "Orders",
    description = "Operations over order resources"
)
public interface OrderController {

    @Tag(name = "Orders")
    Long create(OrderCreationRequest orderCreationRequest);

    @Tag(name = "Orders")
    Page<OrderFindingByFilterResponse> findByFilter(PageRequestDto pageRequestDto);

}
