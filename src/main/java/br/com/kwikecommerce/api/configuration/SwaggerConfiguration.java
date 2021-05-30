package br.com.kwikecommerce.api.configuration;


import br.com.kwikecommerce.api.property.ApiInfoProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.Set;


@EnableSwagger2
@Configuration
@RequiredArgsConstructor
public class SwaggerConfiguration {

    private static final Set<String> APPLICATION_JSON = Collections.singleton("application/json");
    private static final String BASE_PACKAGE = "br.com.kwikecommerce.api.controller";
    private final ApiInfoProperty apiInfoProperty;

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("v1-public")
            .select()
            .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(buildApiInfo())
            .consumes(APPLICATION_JSON)
            .produces(APPLICATION_JSON);
    }

    @Bean
    public ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
            .title(apiInfoProperty.getTitle())
            .description(apiInfoProperty.getDescription())
            .version(apiInfoProperty.getVersion())
            .build();
    }

}
