package br.com.kwikecommerce.api.application.configuration;

import br.com.kwikecommerce.api.application.configuration.interceptor.DebbuggerInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@RequiredArgsConstructor
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    private final DebbuggerInterceptor debbuggerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(debbuggerInterceptor);
    }

}
