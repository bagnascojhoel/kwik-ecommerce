package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.domain.Company;
import org.mapstruct.Mapper;


@Mapper
public interface CompanyMapper {

    default Company mapCompanyIdToCompany(Long companyId) {
        return Company.builder()
            .id(companyId)
            .build();
    }

}