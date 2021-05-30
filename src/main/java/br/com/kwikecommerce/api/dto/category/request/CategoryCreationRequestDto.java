package br.com.kwikecommerce.api.dto.category.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CategoryCreationRequestDto {

    @NotEmpty
    @Size(max = 30)
    @ApiModelProperty(
        value = "Name",
        notes = "Max length is 30 characters",
        example = "Cellphones"
    )
    private String name;

}
