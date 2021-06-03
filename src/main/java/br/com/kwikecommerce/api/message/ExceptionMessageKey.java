package br.com.kwikecommerce.api.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum ExceptionMessageKey implements MessageKey {
    CATEGORY_NOT_FOUND("e.category.not-found"),
    UNKNOWN("e.unknown");

    @Getter
    private final String key;

}
