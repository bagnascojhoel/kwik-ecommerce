package br.com.kwikecommerce.api.dto.product.creation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ApiModel
public class ProductCreationRequestDto {

    @ApiModelProperty(
        value = "Product title",
        notes = "Max length is 100",
        example = "WebCam HD Lenovo"
    )
    @NotBlank
    @Size(max = 100)
    private String title;


    @ApiModelProperty(
        value = "Product unitary price",
        notes = "Only two decimal places are used. The limit is 99,999.99",
        example = "135.00")
    @NotNull
    @Min(0)
    @Max(99999)
    private BigDecimal unitaryPrice;


    @ApiModelProperty(
        value = "Current units of the product available",
        example = "37"
    )
    @Min(0)
    private Integer availableQty;


    @ApiModelProperty(
        value = "Description of the product",
        notes = "Here you should write all necessary info of the product",
        example = """
            The webcam as a USB connector with a 2 meter cable. It also has a
            cover for the camera. It has a adjustable support which can be allows
            the camera to be used with any monitor or even without one, directly
            on your desk.
            """
    )
    private String description;

}
