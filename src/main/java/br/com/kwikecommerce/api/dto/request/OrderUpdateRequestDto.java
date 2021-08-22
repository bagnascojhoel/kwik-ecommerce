package br.com.kwikecommerce.api.dto.request;

import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class OrderUpdateRequestDto {

    String status;
    String shipmentType;
    String shipmentPrice;
    String paymentMethod;

}
