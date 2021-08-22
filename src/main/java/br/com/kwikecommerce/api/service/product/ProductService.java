package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.application.dto.response.PageResponseDto;
import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import br.com.kwikecommerce.api.dto.response.ProductListingResponse;
import br.com.kwikecommerce.api.domain.ProductSorting;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ProductService {

    Long createProduct(ProductCreationRequest productCreationRequest, List<MultipartFile> photos);

    PageResponseDto<ProductListingResponse> fetchPage(ProductSorting productSorting, Integer pageNumber);

    PageResponseDto<ProductListingResponse> fetchPageByCategory(
        Long categoryId,
        ProductSorting productSorting,
        Integer pageNumber
    );

}
