package br.com.kwikecommerce.api.dto.category.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Builder
@Data
public class CategoryCreationRequestDto {

    @NotEmpty
    @Size(max = 30)
    private String name;

}
