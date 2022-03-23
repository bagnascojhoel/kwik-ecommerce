package br.com.kwikecommerce.api.controller.v1.domaintypes;

import br.com.kwikecommerce.api.controller.v1.domaintypes.dto.DomainTypeListingResponseDto;
import br.com.kwikecommerce.api.entity.PaymentMethod;
import br.com.kwikecommerce.api.entity.order.OrderStatusType;
import br.com.kwikecommerce.api.mapper.DomainTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/domain-types")
public class DomainTypesController implements DomainTypesApi {

    private final DomainTypeMapper domainTypeMapper;

    @Override
    public Set<DomainTypeListingResponseDto> findOrderStatusTypes() {
        return domainTypeMapper.map(OrderStatusType.values());
    }

    @Override
    public Set<DomainTypeListingResponseDto> findPaymentMethods() {
        return domainTypeMapper.map(PaymentMethod.values());
    }

}
