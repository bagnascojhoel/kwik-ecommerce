package br.com.kwikecommerce.api.service.domain.product;

import br.com.kwikecommerce.api.converter.CategoryProductConverter;
import br.com.kwikecommerce.api.domain.base.SortingOption;
import br.com.kwikecommerce.api.dto.product.request.ProductCreationRequestDto;
import br.com.kwikecommerce.api.dto.product.response.ProductListingResponseDto;
import br.com.kwikecommerce.api.helper.ProductPaginationHelper;
import br.com.kwikecommerce.api.mapper.ProductMapper;
import br.com.kwikecommerce.api.repository.ProductRepository;
import br.com.kwikecommerce.api.service.domain.category.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public record ProductServiceImpl(
    ProductRepository productRepository,
    ProductMapper productMapper,
    CategoryService categoryService,
    CategoryProductConverter categoryProductConverter,
    ProductPaginationHelper paginationUtil
) implements ProductService {

    @Override
    public Long create(ProductCreationRequestDto requestDto) {
        var category = categoryService.fetchById(requestDto.getCategoryId());
        var product = productMapper.map(requestDto, category);
        return productRepository.save(product).getId();
    }

    @Override
    public Page<ProductListingResponseDto> fetchPage(
        SortingOption sortingOption,
        Integer pageNumber
    ) {
        var pageRequest = paginationUtil.buildPageRequest(sortingOption, pageNumber);
        return productRepository.findAll(pageRequest).map(productMapper::map);
    }

    @Override
    public Page<ProductListingResponseDto> fetchPageByCategory(
        Long categoryId,
        SortingOption sortingOption,
        Integer pageNumber
    ) {
        var pageRequest = paginationUtil.buildPageRequest(sortingOption, pageNumber);
        return productRepository.findByCategoryId(categoryId, pageRequest).map(productMapper::map);
    }
}
