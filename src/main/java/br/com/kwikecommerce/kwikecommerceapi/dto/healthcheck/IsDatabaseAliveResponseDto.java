package br.com.kwikecommerce.kwikecommerceapi.dto.healthcheck;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IsDatabaseAliveResponseDto {

    private boolean isAlive;

}
