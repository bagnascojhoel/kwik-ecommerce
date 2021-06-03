package br.com.kwikecommerce.api.dto.category.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreationRequestDto {

    @NotEmpty
    @Size(max = 30)
    @Schema(name = "Name", example = "Mugs")
    String name;

}
