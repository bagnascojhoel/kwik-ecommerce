package br.com.kwikecommerce.api.exception.general;

import br.com.kwikecommerce.api.exception.base.ProxyException;

import static br.com.kwikecommerce.api.message.ExceptionMessageKey.FILE_UPLOAD_FAILED;


public class FileUploadException extends ProxyException {

    public FileUploadException() {
        super(FILE_UPLOAD_FAILED);
    }

}
