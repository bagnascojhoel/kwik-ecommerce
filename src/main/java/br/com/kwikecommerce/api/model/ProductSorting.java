package br.com.kwikecommerce.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;


@Schema(name = "Sorting Option")
@RequiredArgsConstructor
public enum ProductSorting {

    ALPHABETIC_DESC,
    ALPHABETIC_ASC,
    PRICE_DESC,
    PRICE_ASC;

}
