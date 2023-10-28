package br.com.bagnascojhoel.kwik_ecommerce.product.application;

import br.com.bagnascojhoel.kwik_ecommerce.product.domain.*;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductApplicationService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductId saveProduct(@NonNull final Product product) {
        this.productRepository.save(product);
        return product.getId();
    }

    @Transactional
    public Optional<Product> findProduct(@NonNull final ProductId productId) {
        return this.productRepository.findById(productId);
    }

    @Transactional
    public void showProduct(@NonNull final ProductId productId) {
        this.productRepository.findById(productId)
                .map(Product::show)
                .ifPresentOrElse(productRepository::save, this::throwProductNotFound);
    }

    @Transactional
    public void hideProduct(@NonNull final ProductId productId) {
        this.productRepository.findById(productId)
                .map(Product::hide)
                .ifPresentOrElse(productRepository::save, this::throwProductNotFound);
    }

    @Transactional
    public void archiveProduct(@NonNull final ProductId productId) {
        this.productRepository.findById(productId)
                .map(Product::archive)
                .ifPresentOrElse(productRepository::save, this::throwProductNotFound);
    }

    @Transactional
    public List<Product> findProductsToShowCustomers() {
        return this.productRepository.findAllByState(ProductState.SHOWN);
    }

    private void throwProductNotFound() {
        throw new ProductNotFound();
    }

}
