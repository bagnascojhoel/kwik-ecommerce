package br.com.kwikecommerce.api.dto.request;

import br.com.kwikecommerce.api.domain.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;


@Value
@Builder
public class OrderUpdateRequestDto {

    @JsonIgnore
    @Schema(example = "CORREIOS")
    String freightType;

    @Schema(example = "12.5")
    BigDecimal freightPrice;

    @Schema(example = "CREDIT_CARD")
    PaymentMethod paymentMethod;

}
