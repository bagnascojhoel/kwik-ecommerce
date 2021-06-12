package br.com.kwikecommerce.api.application.exception;

import br.com.kwikecommerce.api.application.exception.base.ProxyException;

import static br.com.kwikecommerce.api.message.ExceptionMessageKey.FILE_UPLOAD_FAILED;


public class FileUploadException extends ProxyException {

    public FileUploadException() {
        super(FILE_UPLOAD_FAILED);
    }

}
