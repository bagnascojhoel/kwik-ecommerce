package br.com.kwikecommerce.api.pagination.sort;

import br.com.kwikecommerce.api.application.exception.InternalServerException;
import br.com.kwikecommerce.api.message.MessageProperty;
import lombok.Getter;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class KwikSort<T extends Enum> {

    private static final String SORT_PARTS_SEPARATOR = " ";
    private static final String SORTS_SEPARATOR = ";";

    @Getter
    private final Sort sort;

    protected KwikSort(Class<T> anEnum, String aString) {
        var sortSections = splitSections(aString);
        var sortOption = SortOptionFactory.create(anEnum);
        if (KwikSort.isNotASortString(sortOption, sortSections))
            throw new InternalServerException(
                MessageProperty.of("log.attempted-to-build-invalid-sort", aString)
            );

        this.sort = this.createSort(sortOption, sortSections);
    }

    private static boolean isNotASortString(SortOption sortOption, Set<SortSection> sections) {
        for (var section : sections) {
            var isValidDirection = Sort.Direction.fromOptionalString(section.getDirection()).isPresent();
            var isValidPropertyOption = sortOption.valueOptionalOfOption(section.getProperty()).isPresent();

            if (isValidDirection && isValidPropertyOption)
                return false;
        }

        return true;
    }

    private <U extends SortOption> Sort createSort(U sortOption, Set<SortSection> sections) {
        var orders = new ArrayList<Sort.Order>();
        sections.forEach(section -> {
            var direction = Sort.Direction.fromString(section.getDirection());
            var property = sortOption.valueOfOption(section.getProperty());

            orders.add(new Sort.Order(direction, property));
        });

        return Sort.by(orders);
    }

    private Set<SortSection> splitSections(String aString) {
        if (StringUtils.isBlank(aString))
            return Collections.emptySet();

        var result = new HashSet<SortSection>();
        var sorts = aString.split(SORTS_SEPARATOR);
        for (var sort : sorts) {
            if (!sort.contains(SORT_PARTS_SEPARATOR))
                return Collections.emptySet();

            var sortParts = sort.split(SORT_PARTS_SEPARATOR);
            var property = sortParts[0];
            var direction = sortParts[1];

            result.add(new SortSection(property, direction));
        }

        return result;
    }

    @Value
    private static final class SortSection {
        String property;
        String direction;
    }

}
