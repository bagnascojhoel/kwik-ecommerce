package br.com.kwikecommerce.api.controller.domaintypes.dto;

import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class DomainTypeListingResponseDto {

    String name;
    String description;

}
