package br.com.kwikecommerce.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Builder
@Data
@AllArgsConstructor
public class ProductListingResponse {

    private String title;
    private BigDecimal unitaryPrice;
    private Integer availableQty;
    private String description;
    private Long categoryId;
    private List<String> photosUrls;

}
