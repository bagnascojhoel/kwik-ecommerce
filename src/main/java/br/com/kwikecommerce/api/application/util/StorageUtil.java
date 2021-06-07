package br.com.kwikecommerce.api.application.util;

import br.com.kwikecommerce.api.application.property.AwsProperty;
import br.com.kwikecommerce.api.application.service.logging.LogService;
import br.com.kwikecommerce.api.exception.general.ExtensionDiscoveryException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

import static java.util.Objects.isNull;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;


@Component
public record StorageUtil(
    LogService logService,
    AwsProperty awsProperty
) {

    private static final Map<String, String> relations = Map.of(
        IMAGE_PNG_VALUE, ".png",
        IMAGE_JPEG_VALUE, ".jpg"
    );

    public String discoverExtension(MultipartFile file) {
        var contentType = file.getContentType();
        var cannotDiscoverExtension = isNull(contentType) || !relations.containsKey(contentType);
        if (cannotDiscoverExtension) {
            logService.logError("Couldn't discover extension from Content-Type: {0}", file.getContentType());
            throw new ExtensionDiscoveryException();
        }

        return relations.get(contentType);
    }

}
