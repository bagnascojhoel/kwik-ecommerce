package br.com.bagnascojhoel.kwik_ecommerce.common.driving_infra.rest;

<<<<<<< HEAD
import io.swagger.v3.oas.annotations.media.Schema;
=======
<<<<<<< Updated upstream
=======
import io.swagger.v3.oas.annotations.media.Schema;
>>>>>>> Stashed changes
>>>>>>> 6de344b (docs: add swagger ui)
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class FailedValidationDto {
    @Schema(examples = {"productName", "client.address[0]"})
    private final String field;

    @Schema(example = "Exceeded maximum of 20 characters")
    private final String reason;

}
