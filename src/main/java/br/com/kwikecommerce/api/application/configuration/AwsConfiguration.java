package br.com.kwikecommerce.api.application.configuration;

import br.com.kwikecommerce.api.application.property.AwsProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;


@RequiredArgsConstructor
@Configuration
public class AwsConfiguration {

    private final AwsProperty awsProperty;

    @Bean
    public S3Client buildS3Client() {
        var credentialsProvider = StaticCredentialsProvider.create(buildCredentials());

        return S3Client.builder()
            .credentialsProvider(credentialsProvider)
            .region(Region.of(awsProperty.getS3().getRegion()))
            .build();
    }

    private AwsCredentials buildCredentials() {
        return new AwsCredentials() {
            @Override
            public String accessKeyId() {
                return awsProperty.getAccessKey();
            }

            @Override
            public String secretAccessKey() {
                return awsProperty.getSecretKey();
            }
        };
    }

}
