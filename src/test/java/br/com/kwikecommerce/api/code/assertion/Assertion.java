package br.com.kwikecommerce.api.code.assertion;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;


@Component
public record Assertion(
    EntityManagerFactory entityManagerFactory
) {

    public static DatabaseAssertion DATABASE;

    public Assertion {
        var entityManager = entityManagerFactory.createEntityManager();
        DATABASE = new DatabaseAssertion(entityManager);
    }

}
