package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.controller.v1.domaintypes.dto.DomainTypeListingResponseDto;
import br.com.kwikecommerce.api.entity.DomainType;
import org.mapstruct.Mapper;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


@Mapper
public interface DomainTypeMapper {

    default Set<DomainTypeListingResponseDto> map(DomainType[] domainTypes) {
        return Arrays.stream(domainTypes)
            .map(domainType ->
                DomainTypeListingResponseDto.builder()
                    .name(domainType.name())
                    .description(domainType.getDescription())
                    .build()

            )
            .collect(Collectors.toSet());
    }

}
