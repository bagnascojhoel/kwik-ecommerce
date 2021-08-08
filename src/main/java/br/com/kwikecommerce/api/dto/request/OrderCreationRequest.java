package br.com.kwikecommerce.api.dto.request;

import br.com.kwikecommerce.api.model.PaymentMethod;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Value
public class OrderCreationRequest {

    // TODO jhoel.bagnasco esse campo no futuro será buscado do token de atenticação
    @NotNull
    @Schema(example = "1")
    Long companyId;

    @NotBlank
    @Schema(example = "Jonas Fonseca")
    String customerName;

    @NotBlank
    @Schema(example = "Brasil, São Paulo, São Paulo, Guarulhos, Av. Araújo Viana, 33")
    String customerAddress;

    @NotBlank
    @Schema(example = "48322888692")
    String customerPhoneNumber;

    @NotNull
    @Schema(example = "PIX")
    PaymentMethod paymentMethod;

    @NotNull
    @Schema(example = "56.99")
    BigDecimal totalPrice;

    @Schema(example = "4.67")
    BigDecimal freightPrice;

}
