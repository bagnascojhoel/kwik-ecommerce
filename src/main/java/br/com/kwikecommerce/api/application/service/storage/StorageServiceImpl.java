package br.com.kwikecommerce.api.application.service.storage;

import br.com.kwikecommerce.api.application.Storage;
import br.com.kwikecommerce.api.application.property.AwsProperty;
import br.com.kwikecommerce.api.application.service.logging.LogService;
import br.com.kwikecommerce.api.application.util.StorageUtil;
import br.com.kwikecommerce.api.application.exception.FileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public record StorageServiceImpl(
    S3Client s3Client,
    AwsProperty awsProperty,
    StorageUtil storageUtil,
    LogService logService
) implements StorageService {

    @Override
    public List<String> upload(Storage storage, List<MultipartFile> multipartFiles) {
        var result = new ArrayList<String>();

        for (var file : multipartFiles)
            result.add(upload(storage, file));

        return result;
    }

    @Override
    public String upload(Storage storage, MultipartFile file) {
        var key = buildObjectKey(storage.getFolder(), file);
        var request = PutObjectRequest.builder()
            .contentType(file.getContentType())
            .contentDisposition("inline")
            .bucket(awsProperty.getS3().getBucket())
            .key(key)
            .build();

        try {
            s3Client.putObject(request, RequestBody.fromBytes(file.getBytes()));
        } catch (IOException ex) {
            logService.logError("Error while uploading file", ex);
            throw new FileUploadException();
        }

        return buildFileUrl(key);
    }

    private String buildObjectKey(String folder, MultipartFile file) {
        return folder + "/" + UUID.randomUUID() + storageUtil.discoverExtension(file);
    }

    private String buildFileUrl(String objectKey) {
        var fixedBucket = awsProperty.getS3().getBucket().toLowerCase();
        return "https://"
            + fixedBucket
            + ".s3.amazonaws.com/"
            + objectKey;
    }

}
