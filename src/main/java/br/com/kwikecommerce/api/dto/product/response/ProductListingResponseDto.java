package br.com.kwikecommerce.api.dto.product.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Builder
@Data
@AllArgsConstructor
public class ProductListingResponseDto {

    String title;
    BigDecimal unitaryPrice;
    Integer availableQty;
    String description;
    Long categoryId;
    List<String> photosUrls;

}
