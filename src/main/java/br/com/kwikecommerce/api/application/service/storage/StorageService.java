package br.com.kwikecommerce.api.application.service.storage;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface StorageService {

    List<String> upload(String folder, List<MultipartFile> photos);

    String upload(String folder, MultipartFile multipartFile);

}
