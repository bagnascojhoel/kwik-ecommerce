package br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driven_ports.product;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.DomainFixtures;
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductState;
import br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driven_ports.AbstractJdbcRepositoryTest;
import org.junit.jupiter.api.BeforeEach;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductDomainFixtures;
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductState;
import br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driven_ports.AbstractJdbcRepositoryTest;
import org.junit.jupiter.api.AfterEach;
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.jdbc.JdbcTestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Import({JdbcProductRepository.class, ProductParameterSource.class, ProductRowMapper.class})
public class JdbcProductRepositoryTest extends AbstractJdbcRepositoryTest {

    @Autowired
    private JdbcProductRepository jdbcProductRepository;

<<<<<<< HEAD
    @BeforeEach
=======
<<<<<<< HEAD
    @BeforeEach
=======
<<<<<<< HEAD
    @BeforeEach
=======
    @AfterEach
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
    void beforeEach() {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "product");
    }

    @Nested
    class Save {
        @Test
        void shouldThrowWhenProductIsNull() {
            assertThatThrownBy(() -> jdbcProductRepository.save(null))
                    .isInstanceOf(NullPointerException.class);
        }

        @Test
        void shouldInsertProductWhenIdDoesNotExist() {
<<<<<<< HEAD
            jdbcProductRepository.save(DomainFixtures.PEPERONI_PIZZA);
=======
<<<<<<< HEAD
            jdbcProductRepository.save(DomainFixtures.PEPERONI_PIZZA);
=======
<<<<<<< HEAD
            jdbcProductRepository.save(DomainFixtures.PEPERONI_PIZZA);
=======
            jdbcProductRepository.save(ProductDomainFixtures.PEPERONI_PIZZA);
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)

            JdbcTestUtils.countRowsInTable(jdbcTemplate, "product");
        }

        @Test
        void shouldUpdateProductWhenIdDoesExist() {
<<<<<<< HEAD
            var peperoniPizza = DomainFixtures.PEPERONI_PIZZA;
=======
<<<<<<< HEAD
            var peperoniPizza = DomainFixtures.PEPERONI_PIZZA;
=======
<<<<<<< HEAD
            var peperoniPizza = DomainFixtures.PEPERONI_PIZZA;
=======
            var peperoniPizza = ProductDomainFixtures.PEPERONI_PIZZA;
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
            jdbcProductRepository.save(peperoniPizza);

            peperoniPizza = peperoniPizza.toBuilder()
                    .name("modified name")
                    .build();

            jdbcProductRepository.save(peperoniPizza);

            JdbcTestUtils.countRowsInTable(jdbcTemplate, "product");
<<<<<<< HEAD
            assertModifiedFieldsAreFilled("product", peperoniPizza.getId().rawValue());
=======
<<<<<<< HEAD
            assertModifiedFieldsAreFilled("product", peperoniPizza.getId().rawValue());
=======
<<<<<<< HEAD
            assertModifiedFieldsAreFilled("product", peperoniPizza.getId().rawValue());
=======
            assertModifiedFieldsAreFilled("product", peperoniPizza.getId().rawValue);
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
        }
    }

    @Nested
    class FindById {
        @Test
        void shouldThrowWhenIdIsNull() {
            assertThatThrownBy(() -> jdbcProductRepository.findById(null))
                    .isInstanceOf(NullPointerException.class);
        }

        @Test
        void shouldReturnProductWhenIdExists() {
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
            jdbcProductRepository.save(DomainFixtures.PEPERONI_PIZZA);

            var product = jdbcProductRepository.findById(DomainFixtures.PEPERONI_PIZZA.getId());

            assertThat(product).isNotEmpty();
            assertThat(product.get()).isEqualTo(DomainFixtures.PEPERONI_PIZZA);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
            jdbcProductRepository.save(ProductDomainFixtures.PEPERONI_PIZZA);

            var product = jdbcProductRepository.findById(ProductDomainFixtures.PEPERONI_PIZZA.getId());

            assertThat(product).isNotEmpty();
            assertThat(product.get()).isEqualTo(ProductDomainFixtures.PEPERONI_PIZZA);
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
        }

        @Test
        void shouldReturnEmptyWhenIdDoesNotExist() {
<<<<<<< HEAD
            var product = jdbcProductRepository.findById(DomainFixtures.PEPERONI_PIZZA.getId());
=======
<<<<<<< HEAD
            var product = jdbcProductRepository.findById(DomainFixtures.PEPERONI_PIZZA.getId());
=======
<<<<<<< HEAD
            var product = jdbcProductRepository.findById(DomainFixtures.PEPERONI_PIZZA.getId());
=======
            var product = jdbcProductRepository.findById(ProductDomainFixtures.PEPERONI_PIZZA.getId());
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)

            assertThat(product).isEmpty();
        }
    }

    @Nested
    class FindAllByState {
        @Test
        void shouldThrowWhenStateIsNull() {
            assertThatThrownBy(() -> jdbcProductRepository.findAllByState(null))
                    .isInstanceOf(NullPointerException.class);
        }

        @Test
        void shouldReturnOnlyProductsShownWhenFindingByStateShown() {
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
            jdbcProductRepository.save(DomainFixtures.PEPERONI_PIZZA);
            jdbcProductRepository.save(DomainFixtures.DOUBLE_CHEESE_BURGUER);

            var products = jdbcProductRepository.findAllByState(ProductState.SHOWN);

            assertThat(products).containsOnly(DomainFixtures.PEPERONI_PIZZA);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
            jdbcProductRepository.save(ProductDomainFixtures.PEPERONI_PIZZA);
            jdbcProductRepository.save(ProductDomainFixtures.DOUBLE_CHEESE_BURGUER);

            var products = jdbcProductRepository.findAllByState(ProductState.SHOWN);

            assertThat(products).containsOnly(ProductDomainFixtures.PEPERONI_PIZZA);
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
        }
    }

    @Nested
    class FindAll {
        @Test
        void shouldReturnAllProducts() {
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
            jdbcProductRepository.save(DomainFixtures.PEPERONI_PIZZA);
            jdbcProductRepository.save(DomainFixtures.DOUBLE_CHEESE_BURGUER);

            var products = jdbcProductRepository.findAll();

            assertThat(products).containsOnly(DomainFixtures.PEPERONI_PIZZA, DomainFixtures.DOUBLE_CHEESE_BURGUER);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
            jdbcProductRepository.save(ProductDomainFixtures.PEPERONI_PIZZA);
            jdbcProductRepository.save(ProductDomainFixtures.DOUBLE_CHEESE_BURGUER);

            var products = jdbcProductRepository.findAll();

            assertThat(products).containsOnly(ProductDomainFixtures.PEPERONI_PIZZA, ProductDomainFixtures.DOUBLE_CHEESE_BURGUER);
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
        }
    }
}
