package br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driving_ports;

import br.com.bagnascojhoel.kwik_ecommerce.product.application.ProductApplicationService;
<<<<<<< HEAD
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.DomainFixtures;
=======
<<<<<<< HEAD
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.DomainFixtures;
=======
<<<<<<< HEAD
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.DomainFixtures;
=======
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductDomainFixtures;
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductId;
import br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driving_ports.rest.ProductResourceFactory;
import br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driving_ports.rest.ProductRestController;
import br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driving_ports.rest.RestBasePaths;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import java.util.List;

<<<<<<< HEAD
import static br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driving_ports.RestFixtures.ALL_PRODUCTS_JSON_PATH;
import static br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driving_ports.RestFixtures.PEPERONI_PIZZA_JSON_PATH;
=======
<<<<<<< HEAD
import static br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driving_ports.RestFixtures.ALL_PRODUCTS_JSON_PATH;
import static br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driving_ports.RestFixtures.PEPERONI_PIZZA_JSON_PATH;
=======
<<<<<<< HEAD
import static br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driving_ports.RestFixtures.ALL_PRODUCTS_JSON_PATH;
import static br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driving_ports.RestFixtures.PEPERONI_PIZZA_JSON_PATH;
=======
import static br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driving_ports.ProductRestFixtures.ALL_PRODUCTS_JSON_PATH;
import static br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driving_ports.ProductRestFixtures.PEPERONI_PIZZA_JSON_PATH;
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@Import({ProductResourceFactory.class, ProductRestController.class})
public class ProductRestControllerTest extends AbstractRestControllerTest {

    @MockBean
    private ProductApplicationService productApplicationService;

    @Nested
    class PostProducts {

        @Test
        @DisplayName("POST " + RestBasePaths.MANAGER_PRODUCTS + " - 201 CREATED")
        void shouldPostToProductSuccessfully() {
            RestAssuredMockMvc
                    .given()
                    .body(loadJson(PEPERONI_PIZZA_JSON_PATH))
                    .contentType(ContentType.JSON)
                    .post(RestBasePaths.MANAGER_PRODUCTS)
                    .then()
                    .statusCode(201)
                    .body(Matchers.isEmptyOrNullString());

            verify(productApplicationService).saveProduct(any());
        }

    }

    @Nested
    class GetAllProducts {
        @Test
        @DisplayName("GET " + RestBasePaths.MANAGER_PRODUCTS + " - 200 OK")
        void shouldGetProductsSuccessfully() {
            // it is not relevant that I am using a hidden product since I am not testing business logic
            when(productApplicationService.findAllProducts())
<<<<<<< HEAD
                    .thenReturn(List.of(DomainFixtures.PEPERONI_PIZZA, DomainFixtures.DOUBLE_CHEESE_BURGUER));
=======
<<<<<<< HEAD
                    .thenReturn(List.of(DomainFixtures.PEPERONI_PIZZA, DomainFixtures.DOUBLE_CHEESE_BURGUER));
=======
<<<<<<< HEAD
                    .thenReturn(List.of(DomainFixtures.PEPERONI_PIZZA, DomainFixtures.DOUBLE_CHEESE_BURGUER));
=======
                    .thenReturn(List.of(ProductDomainFixtures.PEPERONI_PIZZA, ProductDomainFixtures.DOUBLE_CHEESE_BURGUER));
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)

            RestAssuredMockMvc
                    .given()
                    .get(RestBasePaths.MANAGER_PRODUCTS)
                    .then()
                    .statusCode(200)
                    .body(matchesJsonSchemaInClasspath(ALL_PRODUCTS_JSON_PATH));

            verify(productApplicationService).findAllProducts();
        }
    }

    @Nested
    class GetProductById {
        @Test
        @DisplayName("GET " + RestBasePaths.MANAGER_PRODUCTS + "/{productId} - 200 OK")
        void shouldGetProductSuccessfully() {
            var productId = ProductId.generate();

            when(productApplicationService.getProductById(productId))
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
                    .thenReturn(DomainFixtures.PEPERONI_PIZZA);

            RestAssuredMockMvc
                    .given()
                    .get(RestBasePaths.MANAGER_PRODUCTS + "/{productId}", productId.rawValue())
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
                    .thenReturn(ProductDomainFixtures.PEPERONI_PIZZA);

            RestAssuredMockMvc
                    .given()
                    .get(RestBasePaths.MANAGER_PRODUCTS + "/{productId}", productId.toString())
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
                    .then()
                    .statusCode(200)
                    .body(matchesJsonSchemaInClasspath(PEPERONI_PIZZA_JSON_PATH));

            verify(productApplicationService).getProductById(productId);
        }
    }

    @Nested
    class PostArchiveProduct {
        @Test
        @DisplayName("POST " + RestBasePaths.MANAGER_PRODUCTS + "/{productId}/archive - 200 OK")
        void shouldPostArchiveProduct() {
            var productId = ProductId.generate();

            RestAssuredMockMvc
                    .given()
<<<<<<< HEAD
                    .post(RestBasePaths.MANAGER_PRODUCTS + "/{productId}/archive", productId.rawValue())
=======
<<<<<<< HEAD
                    .post(RestBasePaths.MANAGER_PRODUCTS + "/{productId}/archive", productId.rawValue())
=======
<<<<<<< HEAD
                    .post(RestBasePaths.MANAGER_PRODUCTS + "/{productId}/archive", productId.rawValue())
=======
                    .post(RestBasePaths.MANAGER_PRODUCTS + "/{productId}/archive", productId.toString())
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
                    .then()
                    .statusCode(200);

            verify(productApplicationService).archiveProduct(productId);
        }
    }

    @Nested
    class PostHideProduct {
        @Test
        @DisplayName("POST " + RestBasePaths.MANAGER_PRODUCTS + "/{productId}/hide - 200 OK")
        void shouldPostHideProduct() {
            var productId = ProductId.generate();

            RestAssuredMockMvc
                    .given()
<<<<<<< HEAD
                    .post(RestBasePaths.MANAGER_PRODUCTS + "/{productId}/hide", productId.rawValue())
=======
<<<<<<< HEAD
                    .post(RestBasePaths.MANAGER_PRODUCTS + "/{productId}/hide", productId.rawValue())
=======
<<<<<<< HEAD
                    .post(RestBasePaths.MANAGER_PRODUCTS + "/{productId}/hide", productId.rawValue())
=======
                    .post(RestBasePaths.MANAGER_PRODUCTS + "/{productId}/hide", productId.toString())
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
                    .then()
                    .statusCode(200);

            verify(productApplicationService).hideProduct(productId);
        }
    }

    @Nested
    class PostShowProduct {
        @Test
        @DisplayName("POST " + RestBasePaths.MANAGER_PRODUCTS + "/{productId}/show - 200 OK")
        void shouldPostHideProduct() {
            var productId = ProductId.generate();

            RestAssuredMockMvc
                    .given()
<<<<<<< HEAD
                    .post(RestBasePaths.MANAGER_PRODUCTS + "/{productId}/show", productId.rawValue())
=======
<<<<<<< HEAD
                    .post(RestBasePaths.MANAGER_PRODUCTS + "/{productId}/show", productId.rawValue())
=======
<<<<<<< HEAD
                    .post(RestBasePaths.MANAGER_PRODUCTS + "/{productId}/show", productId.rawValue())
=======
                    .post(RestBasePaths.MANAGER_PRODUCTS + "/{productId}/show", productId.toString())
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
                    .then()
                    .statusCode(200);

            verify(productApplicationService).showProduct(productId);
        }
    }
<<<<<<< HEAD
    
=======
<<<<<<< HEAD
    
=======
<<<<<<< HEAD
    
=======

>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
}
