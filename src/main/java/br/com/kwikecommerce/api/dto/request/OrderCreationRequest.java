package br.com.kwikecommerce.api.dto.request;

import br.com.kwikecommerce.api.model.PaymentMethod;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class OrderCreationRequest {

    private Long companyId;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private PaymentMethod paymentMethod;
    private BigDecimal totalPrice;
    private BigDecimal freightPrice;

}
