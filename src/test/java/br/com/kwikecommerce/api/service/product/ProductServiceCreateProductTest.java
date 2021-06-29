package br.com.kwikecommerce.api.service.product;

import br.com.kwikecommerce.api.application.service.storage.StorageService;
import br.com.kwikecommerce.api.code.UnitTest;
import br.com.kwikecommerce.api.code.random.Random;
import br.com.kwikecommerce.api.domain.Product;
import br.com.kwikecommerce.api.dto.request.ProductCreationRequest;
import br.com.kwikecommerce.api.mapper.ProductMapper;
import br.com.kwikecommerce.api.repository.ProductRepository;
import br.com.kwikecommerce.api.validator.ProductValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;

import static br.com.kwikecommerce.api.application.Storage.PRODUCT_IMAGES;
import static org.mockito.Mockito.*;


class ProductServiceCreateProductTest extends UnitTest {

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

    @Nested
    class InnerA {

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


    // TODO: 27/06/2021 adicionar lógica a esse teste
    @Test
    void shouldReturnSavedProductId() {
        // Arrange
        var request = Random.OBJECT.next(ProductCreationRequest.class);
        var images = Random.OBJECT.nextList(MockMultipartFile.class, MultipartFile.class);

        when(storageService.upload(eq(PRODUCT_IMAGES), anyList())).thenReturn(Collections.emptyList());

        var product = Random.ENTITY.next(Product.class);
        when(productMapper.map(any(ProductCreationRequest.class), anyList())).thenReturn(product);

        product.setId(Random.PRIMITIVE.nextLong());
        when(productRepository.save(any(Product.class))).thenReturn(product);

        // Act
        subject.createProduct(request, images);

        // Assert

    }

    // TODO: 29/06/2021 testar o retorno do método

}