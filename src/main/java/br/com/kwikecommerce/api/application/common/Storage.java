package br.com.kwikecommerce.api.application.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum Storage {
    PRODUCT_IMAGES("product-images");

    @Getter
    private final String folder;

}
