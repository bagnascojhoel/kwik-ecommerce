package br.com.kwikecommerce.kwikecommerceapi.dto.product;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ProductListingDto {

    private String title;
    private BigDecimal unitaryPrice;
    private Integer availableQty;
    private String description;

}
