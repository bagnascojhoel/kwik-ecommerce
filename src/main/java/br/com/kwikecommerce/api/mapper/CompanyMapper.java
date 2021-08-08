package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.model.Company;
import org.mapstruct.Mapper;


@Mapper
public interface CompanyMapper {

    default Company map(Long companyId) {
        return Company.builder()
            .id(companyId)
            .build();
    }

}
