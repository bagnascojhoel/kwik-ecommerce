package br.com.kwikecommerce.api.pagination.sort;

import br.com.kwikecommerce.api.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class SortConverterFactory implements Converter<String, KwikSort<Product.ProductSortOption>> {

    @Override
    public KwikSort<Product.ProductSortOption> convert(String aString) {
        return new KwikSort<>(Product.ProductSortOption.class, aString);
    }

}
