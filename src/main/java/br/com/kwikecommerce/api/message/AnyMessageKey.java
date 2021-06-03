package br.com.kwikecommerce.api.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum AnyMessageKey implements MessageKey {
    ;

    @Getter
    private final String key;

}
