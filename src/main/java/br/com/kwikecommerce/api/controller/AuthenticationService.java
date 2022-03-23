package br.com.kwikecommerce.api.controller;

public interface AuthenticationService {

    String getKeycloakId();

    boolean isAuthenticated();

}
