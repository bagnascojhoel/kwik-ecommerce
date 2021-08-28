package br.com.kwikecommerce.api.application.dto.response;

import lombok.Value;

import java.util.List;


@Value
public class PageResponseDto<T> {

    List<T> content;

    long totalItems;

}
