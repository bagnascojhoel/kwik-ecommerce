package br.com.kwikecommerce.api.application.mapper;

import br.com.kwikecommerce.api.application.dto.response.PageResponse;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;


@Mapper
public interface PaginationMapper {

    default <T> PageResponse<T> map(Page<T> page) {
        return new PageResponse<>(page.getContent(), page.getTotalElements());
    }

}
