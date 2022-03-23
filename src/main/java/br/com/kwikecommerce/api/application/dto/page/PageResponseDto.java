package br.com.kwikecommerce.api.application.dto.page;

import lombok.Value;

import java.util.List;


@Value
public class PageResponseDto<T> {

    List<T> content;

    long totalItems;

}
