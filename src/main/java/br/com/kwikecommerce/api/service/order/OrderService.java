package br.com.kwikecommerce.api.service.order;

import br.com.kwikecommerce.api.application.dto.request.PageRequestDto;
import br.com.kwikecommerce.api.dto.request.OrderCreationRequest;
import br.com.kwikecommerce.api.dto.response.OrderFindingByFilterResponse;
import org.springframework.data.domain.Page;


public interface OrderService {

    Long create(OrderCreationRequest request);

    Page<OrderFindingByFilterResponse> findByFilter(PageRequestDto pageRequestDto);

}
