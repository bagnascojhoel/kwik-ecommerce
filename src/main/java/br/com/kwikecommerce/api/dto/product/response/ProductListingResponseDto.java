package br.com.kwikecommerce.api.dto.product.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Builder
@Data
@AllArgsConstructor
public class ProductListingResponseDto {

    private String title;
    private BigDecimal unitaryPrice;
    private Integer availableQty;
    private String description;

}
