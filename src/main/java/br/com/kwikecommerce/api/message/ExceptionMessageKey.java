package br.com.kwikecommerce.api.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum ExceptionMessageKey implements MessageKey {
    UNKNOWN("e.unknown"),
    EXTENSION_DISCOVERY_FAILED("e.extension-discovery.failed"),
    FILE_UPLOAD_FAILED("e.file-upload.failed"),
    NO_SUCH_ENUM_OPTION("e.enum.invalid-option");

    @Getter
    private final String key;

}
