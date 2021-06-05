package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.domain.base.SortingOption;
import br.com.kwikecommerce.api.dto.product.request.ProductCreationRequest;
import br.com.kwikecommerce.api.dto.product.response.ProductListingResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ProductService {

    Long create(ProductCreationRequest productCreationRequest, List<MultipartFile> photos);

    Page<ProductListingResponseDto> fetchPage(SortingOption sortingOption, Integer pageNumber);

    Page<ProductListingResponseDto> fetchPageByCategory(
        Long categoryId,
        SortingOption sortingOption,
        Integer pageNumber
    );

}
