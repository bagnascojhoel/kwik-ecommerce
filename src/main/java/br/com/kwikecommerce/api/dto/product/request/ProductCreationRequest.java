package br.com.kwikecommerce.api.dto.product.request;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "product")
public class ProductCreationRequest {

    @NotBlank
    @Size(max = 100)
    @Schema(
        name = "title",
        description = "Max length is 100",
        example = "WebCam HD Lenovo"
    )
    String title;

    @NotNull
    @Min(0)
    @Max(99999)
    @Schema(
        name = "unitaryPrice",
        description = "Only two decimal places are used. The limit is 99,999.99",
        example = "135.00"
    )
    BigDecimal unitaryPrice;

    @NotNull
    @Min(0)
    @Schema(
        name = "availableQty",
        example = "37"
    )
    Integer availableQty;

    @NotBlank
    @Schema(
        name = "description",
        description = "Here you should write all necessary info of the product",
        example = """
            The webcam as a USB connector with a 2 meter cable. It also has a
            cover for the camera. It has a adjustable support which can be allows
            the camera to be used with any monitor or even without one, directly
            on your desk.
            """
    )
    String description;

    @NotNull
    @Schema(
        name = "categoryId",
        description = "Define the category which this product belongs to",
        example = "1"
    )
    Long categoryId;

}
