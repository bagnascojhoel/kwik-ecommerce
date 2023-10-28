package br.com.bagnascojhoel.kwik_ecommerce.product.behavior;

import br.com.bagnascojhoel.kwik_ecommerce.product.application.ProductApplicationService;
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.Product;
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductId;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public final class ProductCrudSteps {

    private final ProductApplicationService productApplicationService;

    private ClientState clientState;

    @Before
    public void before() {
        this.clientState = new ClientState();
    }

    @Given("someone is interacting with the application")
    public void someoneIsInteractingWithTheApplication() {
    }

    @Given("they fetch the product by its id")
    public void theyFetchTheProductByItsId() {
        var productId = this.clientState.productId;

        var product = this.productApplicationService.findProduct(productId);

        assertThat(product).isNotEmpty();

        this.clientState.product = product.get();
    }

    @Given("they show the {string} product")
    public void theyShowTheXProduct(@NonNull final String productName) {
        var productId = this.clientState.getProductIdByName(productName);

        this.productApplicationService.showProduct(productId);
    }

    @Given("they archive the {string} product")
    public void theyArchiveTheXProduct(@NonNull final String productName) {
        var productId = this.clientState.getProductIdByName(productName);

        this.productApplicationService.archiveProduct(productId);
    }

    @When("they create the following products:")
    @When("they create a product with:")
    public void theyCreateProduct(final List<Product> products) {
        final List<Product> createdProducts = new ArrayList<>(products.size());
        for (Product product : products) {
            this.clientState.productId = this.productApplicationService.saveProduct(product);
            createdProducts.add(product);
        }
        this.clientState.products = createdProducts;
    }

    @When("they update the product {string} with:")
    public void theyUpdateAProductWith(final String initialProductName, final Product product) {
        var productId = this.clientState.getProductIdByName(initialProductName);
        var productWithCorrectId = product.toBuilder().id(productId).build();
        this.clientState.productId = this.productApplicationService.saveProduct(productWithCorrectId);
    }

    @When("they archive the product by its id")
    public void theyArchiveTheProductByItsId() {
        this.productApplicationService.archiveProduct(this.clientState.productId);
    }

    @When("they show the product to customers")
    public void theyShowTheProductToCustomer() {
        this.productApplicationService.showProduct(this.clientState.productId);
    }

    @When("they hide the product from customers")
    public void theyHideTheProductFromCustomers() {
        this.productApplicationService.hideProduct(this.clientState.productId);
    }

    @When("they fetch all products to show customers")
    public void theyFetchAllProductsToShowToCustomers() {
        this.clientState.products = this.productApplicationService.findProductsToShowCustomers();
    }

    @Then("the product is shown to consumers")
    public void theProductShouldBeShownToCustomers() {
        var product = this.clientState.product;
        assertThat(product).isNotNull();
        assertThat(product.canBeShownToCustomer()).isTrue();
    }

    @Then("the product is hidden from consumers")
    public void theProductShouldBeNotSellable() {
        var product = this.clientState.product;
        assertThat(product).isNotNull();
        assertThat(product.canBeShownToCustomer()).isFalse();
    }

    @Then("the product is archived")
    public void theProductIsArchived() {
        var product = this.clientState.product;
        assertThat(product.isArchived()).isTrue();
    }

    @Then("the product has:")
    public void theProductHas(final Product product) {
        assertThat(this.clientState.product).isEqualTo(product);
    }

    @Then("the following products are returned:")
    public void theFollowingProductsAreReturned(final List<Product> expectedProducts) {
        assertThat(this.clientState.products)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("state")
                .containsAll(expectedProducts);
    }

    @DataTableType
    public Product product(final Map<String, String> source) {
        return Product.builder()
                .id(this.clientState.productId != null ? this.clientState.productId : ProductId.generate())
                .name(source.get("name"))
                .description(source.get("description"))
                .priceInBrl(new BigDecimal(source.get("priceInBrl")))
                .imageUrl(source.get("imageUrl"))
                .build();
    }

    @NoArgsConstructor
    public static final class ClientState {
        private ProductId productId;
        private Product product;
        private List<Product> products;

        public ProductId getProductIdByName(final String productName) {
            return this.products.stream()
                    .filter(product -> productName.equalsIgnoreCase(product.getName()))
                    .map(Product::getId)
                    .findAny()
                    .orElseThrow(() -> new IllegalStateException("product with name does not exist"));
        }
    }

}
