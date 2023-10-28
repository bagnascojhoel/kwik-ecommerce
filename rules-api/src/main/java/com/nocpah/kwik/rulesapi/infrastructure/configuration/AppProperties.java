package com.nocpah.kwik.rulesapi.infrastructure.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("app")
public class AppProperties {
    private String name;
    private String description;
    private String port;
    private String version;
    private ExternalDocs externalDocs;

    @Data
    public static final class ExternalDocs {
        private String description;
        private String url;
    }
}
