package br.com.kwikecommerce.api.entity.product;

import br.com.kwikecommerce.api.pagination.sort.KwikSort;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ProductSortOptionConverter implements Converter<String, KwikSort<ProductSortOption>> {

    @Override
    public KwikSort<ProductSortOption> convert(String aString) {
        return new KwikSort<>(ProductSortOption.class, aString);
    }

}
