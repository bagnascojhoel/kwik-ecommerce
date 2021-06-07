package br.com.kwikecommerce.api.configuration;

import br.com.kwikecommerce.api.application.property.ApiInfoProperty;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@RequiredArgsConstructor
@Configuration
public class OpenApiConfiguration {

    private final ApiInfoProperty apiInfoProperty;

    @Bean
    public OpenAPI buildOpenApi() {
        return new OpenAPI()
            .info(buildInfo());
    }

    private Info buildInfo() {
        return new Info()
            .title(apiInfoProperty.getTitle())
            .description(apiInfoProperty.getDescription())
            .version(apiInfoProperty.getVersion());
    }

}
