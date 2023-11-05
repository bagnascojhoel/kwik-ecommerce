package br.com.bagnascojhoel.kwik_ecommerce.product.application.behavior;


<<<<<<< HEAD
import lombok.AllArgsConstructor;
=======
<<<<<<< HEAD
import lombok.AllArgsConstructor;
=======
<<<<<<< HEAD
import lombok.AllArgsConstructor;
=======
import br.com.bagnascojhoel.kwik_ecommerce.product.domain.ProductRepository;
import br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driven_ports.product.InMemoryProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
import org.springframework.context.annotation.ComponentScan;

@AllArgsConstructor
@ComponentScan(basePackages = {
        "br.com.bagnascojhoel.kwik_ecommerce.product.domain",
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
        "br.com.bagnascojhoel.kwik_ecommerce.product.application",
        "br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driven_ports"
})
public class CucumberBeanConfiguration {

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
        "br.com.bagnascojhoel.kwik_ecommerce.product.application"
})
public class CucumberBeanConfiguration {

    @Bean
    public ProductRepository productRepository() {
        return new InMemoryProductRepository();
    }

>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
}
