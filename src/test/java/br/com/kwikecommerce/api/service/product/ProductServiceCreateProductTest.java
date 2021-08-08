package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.application.service.storage.StorageService;
import br.com.kwikecommerce.api.code.IntegrationTest;
import br.com.kwikecommerce.api.code.UnitTest;
import br.com.kwikecommerce.api.code.assertion.Assertion;
import br.com.kwikecommerce.api.code.random.Random;
import br.com.kwikecommerce.api.model.Category;
import br.com.kwikecommerce.api.model.Company;
import br.com.kwikecommerce.api.model.Product;
import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import br.com.kwikecommerce.api.mapper.ProductMapper;
import br.com.kwikecommerce.api.repository.ProductRepository;
import br.com.kwikecommerce.api.validator.ProductValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static br.com.kwikecommerce.api.application.common.Storage.PRODUCT_IMAGES;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


class ProductServiceCreateProductTest {

    @Nested
    class WithGeneralMockedResponses extends UnitTest {

        @InjectMocks
        ProductServiceImpl subject;

        @Mock
        ProductValidator productValidator;

        @Mock
        StorageService storageService;

        @Mock
        ProductMapper productMapper;

        @Mock
        ProductRepository productRepository;

        @BeforeEach
        void beforeEach() {
            when(storageService.upload(eq(PRODUCT_IMAGES), anyList())).thenReturn(Collections.emptyList());

            var product = Random.ENTITY.next(Product.class);
            when(productMapper.map(any(ProductCreationRequest.class), anyList())).thenReturn(product);

            product.setId(Random.PRIMITIVE.nextLong());
            when(productRepository.save(any(Product.class))).thenReturn(product);
        }

        @Test
        void shouldValidateRequest() {
            // Arrange
            var request = Random.OBJECT.next(ProductCreationRequest.class);
            var images = Random.OBJECT.nextList(MockMultipartFile.class, MultipartFile.class);

            // Act
            subject.createProduct(request, images);

            // Assert
            verify(productValidator).validateProductCreationRequest(any(ProductCreationRequest.class));
        }

        @Test
        void shouldUploadImages() {
            // Arrange
            var request = Random.OBJECT.next(ProductCreationRequest.class);
            var images = Random.OBJECT.nextList(MockMultipartFile.class, MultipartFile.class);

            // Act
            subject.createProduct(request, images);

            // Assert
            verify(storageService).upload(eq(PRODUCT_IMAGES), anyList());
        }

        @Test
        void shouldMapToDomain() {
            // Arrange
            var request = Random.OBJECT.next(ProductCreationRequest.class);
            var images = Random.OBJECT.nextList(MockMultipartFile.class, MultipartFile.class);

            // Act
            subject.createProduct(request, images);

            // Assert
            verify(productMapper).map(any(ProductCreationRequest.class), anyList());
        }

        @Test
        void shouldSave() {
            // Arrange
            var request = Random.OBJECT.next(ProductCreationRequest.class);
            var images = Random.OBJECT.nextList(MockMultipartFile.class, MultipartFile.class);

            // Act
            subject.createProduct(request, images);

            // Assert
            verify(productRepository).save(any(Product.class));
        }
    }

    @Nested
    class IntegrationTests extends IntegrationTest {

        @Autowired
        ProductMapper productMapper;

        @Autowired
        ProductServiceImpl subject;

        // TODO: 27/06/2021 adicionar lógica a esse teste
        @Test
        void shouldReturnSavedProductId() {
            // Arrange
            var company = Random.ENTITY.nextSaved(Company.class);
            var category = Random.ENTITY.nextSaved(
                    Category.class,
                    Map.of("company", company)
            );
            var request = Random.OBJECT.next(ProductCreationRequest.class);
            request.setCompanyId(1L);
            request.setCategoriesIds(Set.of(category.getId()));

            var images = Random.OBJECT.nextList(MockMultipartFile.class, MultipartFile.class);
            var expectedProduct = productMapper.map(request, List.of());

            // Act
            Long actualProductId = subject.createProduct(request, images);

            // Assert
            assertNotNull(actualProductId);
            Assertion.DATABASE.assertEquals(Product.class, actualProductId, expectedProduct);
        }
    }

    // TODO: 29/06/2021 testar o retorno do método

}