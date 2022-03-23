package br.com.kwikecommerce.api.controller.v1.domaintypes.dto;

import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class DomainTypeListingResponseDto {

    String name;
    String description;

}
