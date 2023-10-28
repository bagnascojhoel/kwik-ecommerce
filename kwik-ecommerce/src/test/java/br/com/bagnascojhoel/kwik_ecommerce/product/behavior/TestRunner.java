package br.com.bagnascojhoel.kwik_ecommerce.product.behavior;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        features = "product/features",
        glue = "br.com.bagnascojhoel.kwik_ecommerce.behavior"
)
public class TestRunner {
}
