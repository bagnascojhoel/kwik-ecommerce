package br.com.kwikecommerce.api.dto.healthcheck;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IsDatabaseAliveResponseDto {

    private boolean isAlive;

}
