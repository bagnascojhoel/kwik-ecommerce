package br.com.kwikecommerce.api.dto.response;

import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class DomainTypeListingResponseDto {

    String name;
    String description;

}
