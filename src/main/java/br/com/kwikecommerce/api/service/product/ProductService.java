package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.application.dto.page.PageResponseDto;
import br.com.kwikecommerce.api.controller.v1.product.dto.ProductListingResponse;
import br.com.kwikecommerce.api.entity.Product;
import br.com.kwikecommerce.api.pagination.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ProductService {

    Long createProduct(Product product);

    List<String> uploadImages(List<MultipartFile> files);

    Page<Product> findPage(PageRequest<Product.ProductSortOption> pageRequest);

    PageResponseDto<ProductListingResponse> fetchPageByCategory(
        Long categoryId,
        PageRequest<Product.ProductSortOption> pageRequest
    );

}
