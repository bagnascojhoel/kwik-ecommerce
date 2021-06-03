package br.com.kwikecommerce.api.domain.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;


@Schema(name = "Sorting Option")
@RequiredArgsConstructor
public enum SortingOption {

    ALPHABETIC_DESC,
    ALPHABETIC_ASC,
    PRICE_DESC,
    PRICE_ASC;

}
