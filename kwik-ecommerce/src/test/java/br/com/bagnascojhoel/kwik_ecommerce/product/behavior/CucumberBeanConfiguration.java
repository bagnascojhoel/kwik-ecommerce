package br.com.bagnascojhoel.kwik_ecommerce.product.behavior;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;

@AllArgsConstructor
@ComponentScan(basePackages = {
        "br.com.bagnascojhoel.kwik_ecommerce.product.domain",
        "br.com.bagnascojhoel.kwik_ecommerce.product.application",
        "br.com.bagnascojhoel.kwik_ecommerce.product.code.infrastructure"
})
public class CucumberBeanConfiguration {

}
