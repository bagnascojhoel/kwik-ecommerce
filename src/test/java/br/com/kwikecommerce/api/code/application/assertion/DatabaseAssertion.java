package br.com.kwikecommerce.api.code.application.assertion;

import br.com.kwikecommerce.api.domain.AbstractEntity;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;

import javax.persistence.EntityManager;

import static java.util.Objects.isNull;


@RequiredArgsConstructor
public class DatabaseAssertion {

    private final EntityManager entityManager;

    public <E extends AbstractEntity> void assertEquals(
        Class<E> baseClass,
        Long entityId,
        E expected
    ) {
        E found = entityManager.find(baseClass, entityId);

        failIfDoesNotExists(found, baseClass);
        Assertions.assertEquals(expected, found);
    }

    public <E extends AbstractEntity> void assertExists(Class<E> baseClass, Long entityId) {
        var found = entityManager.find(baseClass, entityId);

        failIfDoesNotExists(found, baseClass);
    }

    private <E extends AbstractEntity> void failIfDoesNotExists(E found, Class<E> baseClass) {
        if (isNull(found))
            Assertions.fail(baseClass.toString() + " does not exist on the database");
    }

}
