package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.code.UnitTest;
import br.com.kwikecommerce.api.code.random.Random;
import br.com.kwikecommerce.api.model.Product;
import br.com.kwikecommerce.api.model.ProductSorting;
import br.com.kwikecommerce.api.dto.response.ProductListingResponse;
import br.com.kwikecommerce.api.helper.ProductPaginationHelper;
import br.com.kwikecommerce.api.mapper.ProductMapper;
import br.com.kwikecommerce.api.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.*;


class ProductServiceFetchPageByCategoryTest extends UnitTest {

    @InjectMocks
    ProductServiceImpl subject;

    @Mock
    ProductPaginationHelper productPaginationHelper;

    @Mock
    ProductRepository productRepository;

    @Mock
    ProductMapper productMapper;

    @BeforeEach
    void beforeEach() {
        when(productPaginationHelper.buildPageable(any(ProductSorting.class), anyInt()))
            .thenReturn(Pageable.unpaged());

        var page = Random.ENTITY.nextPage(Product.class);
        when(productRepository.findByCategories_id(anyLong(), any(Pageable.class)))
            .thenReturn(page);

        var productListingResponse = Random.OBJECT.next(ProductListingResponse.class);
        when(productMapper.map(any(Product.class))).thenReturn(productListingResponse);
    }

    @Test
    void shouldBuildPageable() {
        // Arrange
        var categoryId = Random.PRIMITIVE.nextLong();
        var productSorting = Random.nextEnum(ProductSorting.class);
        var pageNumber = Random.PRIMITIVE.nextInt();

        // Act
        subject.fetchPageByCategory(categoryId, productSorting, pageNumber);

        // Assert
        verify(productPaginationHelper).buildPageable(any(ProductSorting.class), anyInt());
    }

    @Test
    void shouldFindByCategoryId() {
        // Arrange
        var categoryId = Random.PRIMITIVE.nextLong();
        var productSorting = Random.nextEnum(ProductSorting.class);
        var pageNumber = Random.PRIMITIVE.nextInt();

        // Act
        subject.fetchPageByCategory(categoryId, productSorting, pageNumber);

        // Assert
        verify(productRepository).findByCategories_id(anyLong(), any(Pageable.class));
    }

    @Test
    void shouldMapProduct() {
        // Arrange
        var categoryId = Random.PRIMITIVE.nextLong();
        var productSorting = Random.nextEnum(ProductSorting.class);
        var pageNumber = Random.PRIMITIVE.nextInt();

        // Act
        subject.fetchPageByCategory(categoryId, productSorting, pageNumber);

        // Assert
        verify(productMapper).map(any(Product.class));
    }

    // TODO: 29/06/2021 testar o retorno do método


}