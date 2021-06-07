package br.com.kwikecommerce.api.exception.general;

import br.com.kwikecommerce.api.exception.base.BusinessException;
import br.com.kwikecommerce.api.message.ExceptionMessageKey;


public class ExtensionDiscoveryException extends BusinessException {

    public ExtensionDiscoveryException() {
        super(ExceptionMessageKey.EXTENSION_DISCOVERY_FAILED);
    }

}
