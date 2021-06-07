package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.domain.base.SortingOption;
import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import br.com.kwikecommerce.api.dto.response.ProductListingResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ProductService {

    Long create(ProductCreationRequest productCreationRequest, List<MultipartFile> photos);

    Page<ProductListingResponse> fetchPage(SortingOption sortingOption, Integer pageNumber);

    Page<ProductListingResponse> fetchPageByCategory(
        Long categoryId,
        SortingOption sortingOption,
        Integer pageNumber
    );

}
