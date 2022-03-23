package br.com.kwikecommerce.api.application.service.authentication;

public interface AuthenticationService {

    String getKeycloakId();

    boolean isAuthenticated();

}
