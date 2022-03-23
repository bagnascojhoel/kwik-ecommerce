package br.com.kwikecommerce.api.controller.v1.order.dto;

import lombok.Value;

import java.math.BigDecimal;


@Value
public class OrderFindingByFilterResponse {

    String customerName;
    String customerAddress;
    String customerPhoneNumber;
    String paymentMethod;
    BigDecimal totalPrice;
    BigDecimal freightPrice;
    String status;

}
