package br.com.kwikecommerce.api.application.dto.exception;

import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class AuthenticationExceptionResponseDto {

    String message;
    String origin;

}
