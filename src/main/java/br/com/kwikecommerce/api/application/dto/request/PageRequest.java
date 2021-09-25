package br.com.kwikecommerce.api.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Value
public class PageRequest {

    @Schema(example = "1", minimum = "1")
    @NotNull
    @Min(1)
    Integer page;

    @Schema(example = "5", minimum = "1")
    @Max(99)
    @Min(1)
    Integer limit;

    @Schema(example = "name, DESC")
    String sort;

}
