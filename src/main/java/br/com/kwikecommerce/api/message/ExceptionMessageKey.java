package br.com.kwikecommerce.api.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum ExceptionMessageKey implements MessageKey {
    // TODO jhoel.bagnasco 22/08/2021 | Parar de usar enums e utilizar Strings
    UNKNOWN("e.unknown"),
    EXTENSION_DISCOVERY_FAILED("e.extension-discovery.failed"),
    FILE_UPLOAD_FAILED("e.file-upload.failed"),
    NO_SUCH_ENUM_OPTION("e.enum.invalid-option"),
    ORDER_NOT_FOUND("e.order.not-found");

    @Getter
    private final String key;

}
