package br.com.bagnascojhoel.kwik_ecommerce.common.driving_infra.rest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.providers.ActuatorProvider;
import org.springdoc.webmvc.ui.SwaggerIndexTransformer;
import org.springdoc.webmvc.ui.SwaggerResourceResolver;
import org.springdoc.webmvc.ui.SwaggerWebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.stream.Collectors;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Kwik-Ecommerce API",
                description = "Documentation of all endpoints available for kwik.",
                version = "beta"
        ),
        tags = {
                @Tag(name = "/management", description = "Management operations"),
                @Tag(name = "/customer", description = "Customer operations")
        }
)
public class RestDocsConfig {

    @Bean
    public SwaggerWebMvcConfigurer swaggerWebMvcConfigurer(
            SwaggerUiConfigParameters swaggerUiConfigParameters,
            SwaggerIndexTransformer swaggerIndexTransformer,
            Optional<ActuatorProvider> actuatorProvider,
            SwaggerResourceResolver swaggerResourceResolver
    ) {
        return new KwikSwaggerWebMvcConfigurer(
                swaggerUiConfigParameters,
                swaggerIndexTransformer,
                actuatorProvider,
                swaggerResourceResolver);
    }


    public static class KwikSwaggerWebMvcConfigurer extends SwaggerWebMvcConfigurer {
        private final String swaggerPath;

        private final SwaggerIndexTransformer swaggerIndexTransformer;

        private final Optional<ActuatorProvider> actuatorProvider;

        private final SwaggerResourceResolver swaggerResourceResolver;

        public KwikSwaggerWebMvcConfigurer(
                SwaggerUiConfigParameters swaggerUiConfigParameters,
                SwaggerIndexTransformer swaggerIndexTransformer,
                Optional<ActuatorProvider> actuatorProvider,
                SwaggerResourceResolver swaggerResourceResolver
        ) {
            super(swaggerUiConfigParameters, swaggerIndexTransformer, actuatorProvider, swaggerResourceResolver);
            this.swaggerIndexTransformer = swaggerIndexTransformer;
            this.swaggerPath = swaggerUiConfigParameters.getPath();
            this.actuatorProvider = actuatorProvider;
            this.swaggerResourceResolver = swaggerResourceResolver;
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            StringBuilder uiRootPath = new StringBuilder();
            if (swaggerPath.contains("/"))
                uiRootPath.append(swaggerPath, 0, swaggerPath.lastIndexOf("/"));
            if (actuatorProvider.isPresent() && actuatorProvider.get().isUseManagementPort())
                uiRootPath.append(actuatorProvider.get().getBasePath());

            registry.addResourceHandler(uiRootPath + "/swagger-ui/**")
                    .addResourceLocations("/static/swagger-ui/")
                    .resourceChain(false)
                    .addResolver(swaggerResourceResolver)
                    .addTransformer(swaggerIndexTransformer);
        }
    }

    @RestController
    public static class Controller {
//        @GetMapping(path = "/api/meta/docs/{file}")
//        public String getIndexHtml(@PathVariable("file") final String fileName) {
//            return toText(getClass().getResourceAsStream("classpath:/static/swagger-ui/" + fileName));
//        }

        //
//        @GetMapping(path = "/swagger-ui.css", produces = "text/css")
//        public String getCss() {
//            String orig = toText(getClass().getResourceAsStream("/META-INF/resources/webjars/swagger-ui/5.13.0/swagger-ui.css"));
//            String append = toText(getClass().getResourceAsStream("/swagger-ui/override.css"));
//            return orig + append;
//        }
//
        private String toText(InputStream in) {
            return new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
                    .lines().collect(Collectors.joining("\n"));
        }
    }
}
