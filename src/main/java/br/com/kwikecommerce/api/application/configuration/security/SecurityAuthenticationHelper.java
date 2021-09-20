package br.com.kwikecommerce.api.application.configuration.security;

import br.com.kwikecommerce.api.application.dto.response.AuthenticationExceptionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;


@UtilityClass
public class SecurityAuthenticationHelper {

    private static final String AUTH_RESPONSE_MESSAGE = "Não autorizado";
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void handleResponse(
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse
    ) throws IOException {
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setContentType(JSON_CONTENT_TYPE);
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
        httpServletResponse.getWriter().write(buildAuthExceptionStringResponse(httpServletRequest));
    }

    private static String buildAuthExceptionStringResponse(HttpServletRequest httpServletRequest) throws JsonProcessingException {
        var authenticationExceptionResponse = AuthenticationExceptionResponse.builder()
            .message(AUTH_RESPONSE_MESSAGE)
            .origin(getOrigin(httpServletRequest))
            .build();

        return objectMapper.writeValueAsString(authenticationExceptionResponse);
    }

    private static String getOrigin(HttpServletRequest httpServletRequest) {
        return Optional.ofNullable(httpServletRequest.getHeader("X-Request-Origin"))
            .map(r -> "uri=" + r)
            .orElse(httpServletRequest.getContextPath() + httpServletRequest.getServletPath());
    }

}
