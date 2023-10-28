package br.com.bagnascojhoel.kwik_ecommerce.product;


import br.com.bagnascojhoel.kwik_ecommerce.AbstractApplicationServiceTest;
import br.com.bagnascojhoel.kwik_ecommerce.product.application.ProductApplicationService;
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.Product;
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductId;
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductNotFound;
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ContextConfiguration(classes = ProductApplicationService.class)
class ProductApplicationServiceTest extends AbstractApplicationServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductApplicationService productApplicationService;

    @Nested
    class SaveProduct {
        @Test
        void nonNullProduct() {
            assertThatThrownBy(() -> productApplicationService.saveProduct(null))
                    .isInstanceOf(NullPointerException.class);
        }

        @Test
        void passOnTransactionToRepository() {
            Product product = Product.builder().build();
            setupTransactionName("create-product");

            Mockito.
                    doAnswer(inv -> {
                        assertTransactionIsPropagated();
                        return ProductId.generate();
                    })
                    .when(productRepository)
                    .save(product);

            productApplicationService.saveProduct(product);

            verify(productRepository).save(product);
        }
    }

    @Nested
    class FindProduct {
        @Test
        void nonNullProductId() {
            assertThatThrownBy(() -> productApplicationService.findProduct(null))
                    .isInstanceOf(NullPointerException.class);
        }

        @Test
        void passOnTransactionToRepository() {
            Product product = Product.builder().build();
            setupTransactionName("find-product");

            Mockito.
                    doAnswer(inv -> {
                        assertTransactionIsPropagated();
                        return Optional.of(product);
                    })
                    .when(productRepository)
                    .findById(product.getId());

            productApplicationService.findProduct(product.getId());
        }

        @Test
        void throwsProductNotFound() {
            Product product = Product.builder().build();

            when(productRepository.findById(product.getId())).thenReturn(Optional.empty());

            assertThatThrownBy(() -> productApplicationService.showProduct(product.getId()))
                    .hasMessage("product-not-found")
                    .isInstanceOf(ProductNotFound.class);
        }
    }

    @Nested
    class ShowProduct {
        @Test
        void nonNullProductId() {
            assertThatThrownBy(() -> productApplicationService.showProduct(null))
                    .isInstanceOf(NullPointerException.class);
        }

        @Test
        void passOnTransactionToRepository() {
            Product product = Product.builder().build();
            setupTransactionName("show-product");

            Mockito.
                    doAnswer(inv -> {
                        assertTransactionIsPropagated();
                        return Optional.of(product);
                    })
                    .when(productRepository)
                    .findById(product.getId());

            productApplicationService.showProduct(product.getId());
        }

        @Test
        void throwsProductNotFound() {
            Product product = Product.builder().build();

            when(productRepository.findById(product.getId())).thenReturn(Optional.empty());

            assertThatThrownBy(() -> productApplicationService.showProduct(product.getId()))
                    .hasMessage("product-not-found")
                    .isInstanceOf(ProductNotFound.class);
        }
    }

    @Nested
    class HideProduct {
        @Test
        void nonNullProductId() {
            assertThatThrownBy(() -> productApplicationService.hideProduct(null))
                    .isInstanceOf(NullPointerException.class);
        }

        @Test
        void passOnTransactionToRepository() {
            Product product = Product.builder().build();
            setupTransactionName("hide-product");

            Mockito.
                    doAnswer(inv -> {
                        assertTransactionIsPropagated();
                        return Optional.of(product);
                    })
                    .when(productRepository)
                    .findById(product.getId());

            productApplicationService.hideProduct(product.getId());
        }

        @Test
        void throwsProductNotFound() {
            Product product = Product.builder().build();

            when(productRepository.findById(product.getId())).thenReturn(Optional.empty());

            assertThatThrownBy(() -> productApplicationService.showProduct(product.getId()))
                    .hasMessage("product-not-found")
                    .isInstanceOf(ProductNotFound.class);
        }

    }

    @Nested
    class ArchiveProduct {
        @Test
        void nonNullProductId() {
            assertThatThrownBy(() -> productApplicationService.archiveProduct(null))
                    .isInstanceOf(NullPointerException.class);
        }

        @Test
        void passOnTransactionToRepository() {
            Product product = Product.builder().build();
            setupTransactionName("archive-product");

            Mockito.
                    doAnswer(inv -> {
                        assertTransactionIsPropagated();
                        return Optional.of(product);
                    })
                    .when(productRepository)
                    .findById(product.getId());

            productApplicationService.archiveProduct(product.getId());
        }

        @Test
        void throwsProductNotFound() {
            Product product = Product.builder().build();

            when(productRepository.findById(product.getId())).thenReturn(Optional.empty());

            assertThatThrownBy(() -> productApplicationService.showProduct(product.getId()))
                    .hasMessage("product-not-found")
                    .isInstanceOf(ProductNotFound.class);
        }
    }
}