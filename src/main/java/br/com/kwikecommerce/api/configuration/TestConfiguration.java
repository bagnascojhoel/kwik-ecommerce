package br.com.kwikecommerce.api.configuration;

import org.jeasy.random.EasyRandom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TestConfiguration {

    @Bean
    public EasyRandom createEasyRandom() {
        return new EasyRandom();
    }

}
