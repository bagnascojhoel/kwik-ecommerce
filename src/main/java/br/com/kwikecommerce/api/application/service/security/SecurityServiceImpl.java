package br.com.kwikecommerce.api.application.service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


@RequiredArgsConstructor
@Service
public class SecurityServiceImpl implements SecurityService {

    private final HttpServletRequest mockRequest;

    @Override
    public String getKeycloakId() {
        return mockRequest.getUserPrincipal().getName();
    }

}
