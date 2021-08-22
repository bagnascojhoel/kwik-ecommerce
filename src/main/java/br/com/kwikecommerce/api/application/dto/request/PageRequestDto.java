package br.com.kwikecommerce.api.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Value
public class PageRequestDto {

    @Schema(example = "1", minimum = "1")
    @NotNull
    @Size(min = 1)
    Integer page;

    @Schema(example = "5", minimum = "1")
    @Size(min = 1)
    Integer size;

    @Schema(example = "name, DESC")
    String sort;

}
