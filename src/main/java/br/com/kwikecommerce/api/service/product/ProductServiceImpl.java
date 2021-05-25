package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.domain.Constants;
import br.com.kwikecommerce.api.domain.product.SortingOption;
import br.com.kwikecommerce.api.dto.product.ProductListingDto;
import br.com.kwikecommerce.api.dto.product.creation.ProductCreationRequestDto;
import br.com.kwikecommerce.api.mapper.product.ProductMapper;
import br.com.kwikecommerce.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Long createProduct(ProductCreationRequestDto requestDto) {
        var product = productMapper.map(requestDto);

        return productRepository.save(product).getId();
    }

    @Override
    public Page<ProductListingDto> listProducts(Integer pageNumber, SortingOption sortingOption) {
        var sort = buildSort(sortingOption);
        var pageable = PageRequest.of(pageNumber, Constants.PAGE_LENGTH, sort);
        return productMapper.map(productRepository.findAll(pageable));
    }

    private Sort buildSort(SortingOption sortingOption) {
        return switch (sortingOption) {
            case ALPHABETIC_DESC -> Sort.by("title").descending();
            case PRICE_ASC -> Sort.by("unitaryPrice").ascending();
            case PRICE_DESC -> Sort.by("unitaryPrice").descending();
            default -> Sort.by("title").ascending();
        };
    }

}
