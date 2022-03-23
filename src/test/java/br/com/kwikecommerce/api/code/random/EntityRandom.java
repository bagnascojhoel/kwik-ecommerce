package br.com.kwikecommerce.api.code.random;

import br.com.kwikecommerce.api.code.ReflectionUtils;
import br.com.kwikecommerce.api.entity.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class EntityRandom {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public EntityRandom(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public <T extends AbstractEntity> T nextSaved(Class<T> baseClass) {
        var entity = next(baseClass);
        return save(entity);
    }

    public <T extends AbstractEntity> T nextSaved(
        Class<T> baseClass,
        Map<String, Object> properties
    ) {
        var entity = next(baseClass);

        ReflectionUtils.invokeSetters(entity, properties);

        return save(entity);
    }

    // TODO: 01/07/2021 Analisar a performance dessas operações com o EntityManager e EntityManagerFactory
    private <T extends AbstractEntity> T save(T entity) {
        var transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();

        var identifier = entityManagerFactory.getPersistenceUnitUtil().getIdentifier(entity);
        entity.setId((Long) identifier);
        return entity;
    }

    public <T extends AbstractEntity> Page<T> nextPage(Class<T> baseClass) {
        return new PageImpl<T>(nextList(baseClass));
    }

    public <T extends AbstractEntity> List<T> nextList(Class<T> baseClass) {
        return nextList(baseClass, 1);
    }

    public <T extends AbstractEntity> List<T> nextList(Class<T> baseClass, long qty) {
        var result = new ArrayList<T>();

        for (long i = 0; i < qty; i++)
            result.add(next(baseClass));

        return result;
    }

    public <T extends AbstractEntity> T next(Class<T> baseClass) {
        var result = RandomUtils.nextObject(baseClass);
        result.setId(null);

        // TODO: 01/07/2021 Descobrir como criar objeto respeitando as constraints do javax e/ou hibernate
        ReflectionUtils.invokeSettersWithAnnotation(result, null, OneToMany.class);

        return result;
    }

}
