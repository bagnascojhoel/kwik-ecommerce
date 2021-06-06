package br.com.kwikecommerce.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreationRequest {

    @NotBlank
    @Size(min = 3, max = 30)
    @Schema(example = "Mugs")
    private String name;

}
