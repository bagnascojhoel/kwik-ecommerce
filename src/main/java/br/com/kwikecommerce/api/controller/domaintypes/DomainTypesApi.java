package br.com.kwikecommerce.api.controller.domaintypes;

import br.com.kwikecommerce.api.controller.domaintypes.dto.DomainTypeListingResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

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
