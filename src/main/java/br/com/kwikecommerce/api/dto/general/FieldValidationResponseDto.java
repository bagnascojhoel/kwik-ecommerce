package br.com.kwikecommerce.api.dto.general;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class FieldValidationResponseDto {

    public static Object FieldValidation;
    List<FieldValidation> validations;

    @Builder
    @Data
    public static class FieldValidation {

        String field;
        String message;
        String value;

    }

}
