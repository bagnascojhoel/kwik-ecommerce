package br.com.kwikecommerce.api.service.order;

import br.com.kwikecommerce.api.pagination.PageRequest;
import br.com.kwikecommerce.api.application.dto.page.PageResponseDto;
import br.com.kwikecommerce.api.controller.v1.order.dto.OrderFindingByFilterResponse;
import br.com.kwikecommerce.api.controller.v1.order.dto.OrderFindingByIdResponseDto;
import br.com.kwikecommerce.api.entity.Company;
import br.com.kwikecommerce.api.entity.PaymentMethod;
import br.com.kwikecommerce.api.entity.order.Order;

import java.math.BigDecimal;


public interface OrderService {

    Order create(Company company, Order order);

    Order update(Long orderId, PaymentMethod paymentMethod, BigDecimal freightPrice);

    PageResponseDto<OrderFindingByFilterResponse> findByFilter(PageRequest pageRequest);

    OrderFindingByIdResponseDto findById(Long orderId);

}
