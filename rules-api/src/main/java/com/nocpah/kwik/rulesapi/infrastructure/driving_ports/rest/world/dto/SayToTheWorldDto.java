package com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SayToTheWorldDto {
    @Schema(example = "Henrique", minimum = "3", maximum = "30")
    @NotBlank
    @Size(min = 3, max = 30)
    private String sayer;
    @Schema(example = "Vai te fuder", minimum = "5", maximum = "300")
    @NotBlank
    @Size(min = 5, max = 300)
    private String speech;
}
