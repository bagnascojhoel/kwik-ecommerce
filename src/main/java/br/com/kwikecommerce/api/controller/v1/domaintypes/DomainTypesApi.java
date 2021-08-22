package br.com.kwikecommerce.api.controller.v1.domaintypes;

import br.com.kwikecommerce.api.dto.response.DomainTypeListingResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.Set;


@Tag(
    name = "DomainTypes",
    description = "Listing operations for domain types"
)
public interface DomainTypesApi {

    @Tag(name = "DomainTypes")
    @Operation(summary = "Finds all possible order status types")
    Set<DomainTypeListingResponseDto> findOrderStatusTypes();

    @Tag(name = "DomainTypes")
    @Operation(summary = "Finds all possible payment methods")
    Set<DomainTypeListingResponseDto> findPaymentMethods();

}
