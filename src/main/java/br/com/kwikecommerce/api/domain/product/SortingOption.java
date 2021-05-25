package br.com.kwikecommerce.api.domain.product;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum SortingOption {

    ALPHABETIC_DESC,
    ALPHABETIC_ASC,
    PRICE_DESC,
    PRICE_ASC;

}
