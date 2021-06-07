package br.com.kwikecommerce.api.domain.base;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum Storage {
    PRODUCT_PHOTOS("product-photos");

    @Getter
    private final String folder;

}
