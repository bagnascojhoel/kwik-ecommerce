package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.application.service.storage.StorageService;
import br.com.kwikecommerce.api.converter.CategoryProductConverter;
import br.com.kwikecommerce.api.domain.base.SortingOption;
import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import br.com.kwikecommerce.api.dto.response.ProductListingResponse;
import br.com.kwikecommerce.api.helper.ProductPaginationHelper;
import br.com.kwikecommerce.api.mapper.ProductMapper;
import br.com.kwikecommerce.api.repository.ProductRepository;
import br.com.kwikecommerce.api.service.category.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static br.com.kwikecommerce.api.domain.base.Storage.PRODUCT_PHOTOS;


@Service
public record ProductServiceImpl(
    ProductRepository productRepository,
    ProductMapper productMapper,
    ProductPaginationHelper paginationUtil,
    CategoryService categoryService,
    CategoryProductConverter categoryProductConverter,
    StorageService storageService
) implements ProductService {

    @Override
    public Long createProduct(ProductCreationRequest requestDto, List<MultipartFile> photoFiles) {
        var photoUrls = storageService.upload(PRODUCT_PHOTOS.getFolder(), photoFiles);
        var product = productMapper.map(requestDto, photoUrls);
        return productRepository.save(product).getId();
    }

    @Override
    public Page<ProductListingResponse> fetchPage(
        SortingOption sortingOption,
        Integer pageNumber
    ) {
        var pageRequest = paginationUtil.buildPageRequest(sortingOption, pageNumber);
        return productRepository.findAll(pageRequest).map(productMapper::map);
    }

    @Override
    public Page<ProductListingResponse> fetchPageByCategory(
        Long categoryId,
        SortingOption sortingOption,
        Integer pageNumber
    ) {
        var pageRequest = paginationUtil.buildPageRequest(sortingOption, pageNumber);
        return productRepository.findByCategories_id(categoryId, pageRequest)
            .map(productMapper::map);
    }

}
