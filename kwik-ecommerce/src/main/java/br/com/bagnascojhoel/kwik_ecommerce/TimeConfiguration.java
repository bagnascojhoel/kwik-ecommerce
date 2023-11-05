package br.com.bagnascojhoel.kwik_ecommerce;

import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class TimeConfiguration {
<<<<<<< HEAD
    private static final String BRAZIL_TIME_ZONE = "UTC-03:00";
=======
<<<<<<< HEAD
    private static final String BRAZIL_TIME_ZONE = "UTC-03:00";
=======
<<<<<<< HEAD
    private static final String BRAZIL_TIME_ZONE = "UTC-03:00";
=======
    private static final String BRAZIL_TIME_ZONE = "America/Sao_Paulo";
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)

    public TimeConfiguration() {
        TimeZone.setDefault(TimeZone.getTimeZone(BRAZIL_TIME_ZONE));
    }
}
