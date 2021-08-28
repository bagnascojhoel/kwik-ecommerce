package br.com.kwikecommerce.api.dto.request;

import lombok.Data;


@Data
public class StatusCreationRequest {

    private String title;
    private Boolean isActive;

}
