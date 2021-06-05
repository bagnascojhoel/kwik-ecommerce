package br.com.kwikecommerce.api.application.property;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties("aws")
public class AwsProperty {

    S3Property s3;
    String accessKey;
    String secretKey;

    @AllArgsConstructor
    @Getter
    @Setter
    @NoArgsConstructor
    public static class S3Property {

        String bucket;
        String region;

    }

}
