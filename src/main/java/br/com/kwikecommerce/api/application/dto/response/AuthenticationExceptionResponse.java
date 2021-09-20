package br.com.kwikecommerce.api.application.dto.response;

import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class AuthenticationExceptionResponse {

    String message;
    String origin;

}
