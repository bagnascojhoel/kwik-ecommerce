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

@Configuration
@RequiredArgsConstructor
public class SwaggerConfiguration {

    private final ApiInfoProperty apiInfoProperty;

    @Bean
    public Docket buildDocker() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.com.kwikecommerce.kwikecommerceapi"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(buildApiInfo());
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
