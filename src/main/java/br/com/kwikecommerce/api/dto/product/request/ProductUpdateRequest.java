package br.com.kwikecommerce.api.dto.product.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ProductUpdateRequest {

    Long id;
    String title;
    BigDecimal unitaryPrice;
    Integer availableQty;
    String description;

}
