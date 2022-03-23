package br.com.kwikecommerce.api.application.mapper;

import br.com.kwikecommerce.api.application.dto.page.PageResponseDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;


@Mapper
public interface PaginationMapper {

    default <T> PageResponseDto<T> map(Page<T> page) {
        return new PageResponseDto<>(page.getContent(), page.getTotalElements());
    }

}
