package br.com.kwikecommerce.api.dto.response;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;


@Value
@Builder
public class OrderFindingByIdResponseDto {

    String customerName;
    String customerAddress;
    String customerPhoneNumber;
    BigDecimal totalPrice;
    String paymentMethod;
    List<OrderItem> items;

    @Value
    @Builder
    public static class OrderItem {

        Long id;
        Integer quantity;
        BigDecimal unitarySalePrice;
        String description;

    }

}
