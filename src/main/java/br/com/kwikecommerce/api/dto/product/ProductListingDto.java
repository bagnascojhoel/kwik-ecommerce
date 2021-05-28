package br.com.kwikecommerce.api.dto.product;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Builder
@Data
@AllArgsConstructor
public class ProductListingDto {

    private String title;
    private BigDecimal unitaryPrice;
    private Integer availableQty;
    private String description;

}
