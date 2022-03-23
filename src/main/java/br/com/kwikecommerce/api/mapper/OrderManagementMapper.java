package br.com.kwikecommerce.api.mapper;

import br.com.kwikecommerce.api.mapper.CompanyMapper;
import org.mapstruct.Mapper;


@Mapper(uses = CompanyMapper.class)
public interface OrderManagementMapper {


}
