package br.com.kwikecommerce.api.repository;

import br.com.kwikecommerce.api.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepository extends JpaRepository<Company, Long> {

}
