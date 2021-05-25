package br.com.kwikecommerce.api.dto.healthcheck;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class IsAliveResponseDto {

    private Integer value;

}
