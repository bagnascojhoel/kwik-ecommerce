package br.com.kwikecommerce.api.application.configuration;

import br.com.kwikecommerce.api.application.properties.ApiInfoProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@RequiredArgsConstructor
@Configuration
public class OpenApiConfiguration {

    private final ApiInfoProperties apiInfoProperties;

    @Bean
    public OpenAPI buildOpenApi() {
        return new OpenAPI()
            .info(buildInfo());
    }

    private Info buildInfo() {
        return new Info()
            .title(apiInfoProperties.getTitle())
            .description(apiInfoProperties.getDescription())
            .version(apiInfoProperties.getVersion());
    }

}
