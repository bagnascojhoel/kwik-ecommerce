package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.application.service.storage.StorageService;
import br.com.kwikecommerce.api.mapper.CategoryProductMapper;
import br.com.kwikecommerce.api.model.ProductSorting;
import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import br.com.kwikecommerce.api.dto.response.ProductListingResponse;
import br.com.kwikecommerce.api.helper.ProductPaginationHelper;
import br.com.kwikecommerce.api.mapper.ProductMapper;
import br.com.kwikecommerce.api.repository.ProductRepository;
import br.com.kwikecommerce.api.service.category.CategoryService;
import br.com.kwikecommerce.api.validator.ProductValidator;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

import static br.com.kwikecommerce.api.application.common.Storage.PRODUCT_IMAGES;


@Service
public record ProductServiceImpl(
    ProductRepository productRepository,
    ProductMapper productMapper,
    ProductPaginationHelper productPaginationHelper,
    CategoryService categoryService,
    CategoryProductMapper categoryProductMapper,
    StorageService storageService,
    ProductValidator productValidator
) implements ProductService {

    @Override
    public Long createProduct(ProductCreationRequest request, List<MultipartFile> images) {
        productValidator.validateProductCreationRequest(request);

        List<String> imagesUrls = images.isEmpty()
            ? storageService.upload(PRODUCT_IMAGES, images)
            : Collections.emptyList();
        var product = productMapper.map(request, imagesUrls);

        return productRepository.save(product).getId();
    }

    @Override
    public Page<ProductListingResponse> fetchPage(
        ProductSorting productSorting,
        Integer pageNumber
    ) {
        var pageable = productPaginationHelper.buildPageable(productSorting, pageNumber);
        return productRepository.findAll(pageable).map(productMapper::map);
    }

    @Override
    public Page<ProductListingResponse> fetchPageByCategory(
        Long categoryId,
        ProductSorting productSorting,
        Integer pageNumber
    ) {
        var pageable = productPaginationHelper.buildPageable(productSorting, pageNumber);
        return productRepository.findByCategories_id(categoryId, pageable)
            .map(productMapper::map);
    }

}
