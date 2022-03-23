package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.application.dto.page.PageResponseDto;
import br.com.kwikecommerce.api.application.mapper.PaginationMapper;
import br.com.kwikecommerce.api.application.service.storage.StorageService;
import br.com.kwikecommerce.api.controller.v1.product.dto.ProductListingResponse;
import br.com.kwikecommerce.api.entity.Product;
import br.com.kwikecommerce.api.mapper.ProductMapper;
import br.com.kwikecommerce.api.pagination.PageRequest;
import br.com.kwikecommerce.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

import static br.com.kwikecommerce.api.application.common.Storage.PRODUCT_IMAGES;


@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final StorageService storageService;
    private final PaginationMapper paginationMapper;

    @Override
    public Long createProduct(Product product) {
        return productRepository.save(product).getId();
    }

    @Override
    public List<String> uploadImages(List<MultipartFile> files) {
        return files.isEmpty()
            ? storageService.upload(PRODUCT_IMAGES, files)
            : Collections.emptyList();
    }

    @Override
    public Page<Product> findPage(PageRequest<Product.ProductSortOption> pageRequest) {
        return productRepository.findAll(pageRequest);
    }

    @Override
    public PageResponseDto<ProductListingResponse> fetchPageByCategory(
        Long categoryId,
        PageRequest<Product.ProductSortOption> pageRequest
    ) {
        var page = productRepository.findByCategories_id(categoryId, pageRequest)
            .map(productMapper::map);

        return paginationMapper.map(page);
    }

}
