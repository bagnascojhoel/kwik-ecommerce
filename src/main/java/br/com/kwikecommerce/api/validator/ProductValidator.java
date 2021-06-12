package br.com.kwikecommerce.api.validator;

import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import br.com.kwikecommerce.api.exception.category.CategoryNotFoundException;
import br.com.kwikecommerce.api.exception.company.CompanyNotFoundException;
import br.com.kwikecommerce.api.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;


@Component
public record ProductValidator(
    ProductRepository productRepository
) {

    public void validateProductCreationRequest(ProductCreationRequest request) {
        validateCompanyExists(request.getCompanyId());
        validateAllCategoriesExists(request.getCategoriesIds());
    }

    private void validateCompanyExists(Long companyId) {
        if (productRepository.existsById(companyId))
            throw new CompanyNotFoundException();
    }

    private void validateAllCategoriesExists(Collection<Long> categoriesIds) {
        var categoriesQty = Set.of(categoriesIds).size();
        if (categoriesQty > productRepository.countByCategories_idIn(categoriesIds))
            throw new CategoryNotFoundException();
    }

}
