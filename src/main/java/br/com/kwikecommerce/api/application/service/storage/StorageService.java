package br.com.kwikecommerce.api.application.service.storage;

import br.com.kwikecommerce.api.application.Storage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface StorageService {

    List<String> upload(Storage storage, List<MultipartFile> photos);

    String upload(Storage storage, MultipartFile multipartFile);

}
