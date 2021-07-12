package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.model.ProductSorting;
import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import br.com.kwikecommerce.api.dto.response.ProductListingResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ProductService {

    Long createProduct(ProductCreationRequest productCreationRequest, List<MultipartFile> photos);

    Page<ProductListingResponse> fetchPage(ProductSorting productSorting, Integer pageNumber);

    Page<ProductListingResponse> fetchPageByCategory(
        Long categoryId,
        ProductSorting productSorting,
        Integer pageNumber
    );

}
