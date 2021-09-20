package br.com.kwikecommerce.api.application.configuration.security;

import lombok.RequiredArgsConstructor;
import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.filter.KeycloakAuthenticationProcessingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@KeycloakConfiguration
public class SecurityConfiguration extends KeycloakWebSecurityConfigurerAdapter {

    private static final String APP_ACCESS_ROLE = "ACCESS";
    private static final String[] PUBLIC_ENDPOINTS = {
        "/ui",
        "/open-api-3/**",
        "/swagger-ui/**",
    };

    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring()
            .antMatchers(HttpMethod.OPTIONS)
            .antMatchers(PUBLIC_ENDPOINTS);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        super.configure(httpSecurity);
        httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests().anyRequest().hasRole(APP_ACCESS_ROLE);
        httpSecurity.exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint);
    }

    @Bean
    @Override
    public KeycloakAuthenticationProcessingFilter keycloakAuthenticationProcessingFilter() throws Exception {
        var filter = new KeycloakAuthenticationProcessingFilter(this.authenticationManagerBean());
        filter.setSessionAuthenticationStrategy(this.sessionAuthenticationStrategy());
        filter.setAuthenticationFailureHandler(new CustomKeycloakAuthenticationFailureHandler());
        return filter;
    }

    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new NullAuthenticatedSessionStrategy();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        var keycloakAuthenticationProvider = this.keycloakAuthenticationProvider();

        var simpleAuthorityMapper = new SimpleAuthorityMapper();
        simpleAuthorityMapper.setConvertToUpperCase(true);
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(simpleAuthorityMapper);
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    @Bean
    public KeycloakConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

}
