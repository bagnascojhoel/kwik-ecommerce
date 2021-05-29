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
public class ProductUpdateRequestDto {

    private Long id;

    private String title;

    private BigDecimal unitaryPrice;

    private Integer availableQty;

    private String description;

}