package com.nocpah.kwik.rulesapi.infrastructure.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class EntrypointConfiguration {
    private final AppProperties appProperties;

    @Bean
    public OpenAPI openAPI() {
        var info = new Info()
                .title(appProperties.getName())
                .description(appProperties.getDescription())
                .version(appProperties.getVersion());
        var externalDocs = new ExternalDocumentation()
                .description(appProperties.getExternalDocs().getDescription())
                .url(appProperties.getExternalDocs().getUrl());
        var localServer = new Server()
                .description("Local")
                .url("http://localhost:" + appProperties.getPort());
        return new OpenAPI()
                .info(info)
                .externalDocs(externalDocs)
                .servers(List.of(localServer));

    }
}
