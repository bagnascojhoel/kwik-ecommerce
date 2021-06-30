package br.com.kwikecommerce.api.code.application.random;

import br.com.kwikecommerce.api.code.application.ReflectionHelper;
import br.com.kwikecommerce.api.domain.AbstractEntity;
import lombok.RequiredArgsConstructor;
import org.jeasy.random.EasyRandom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
public class EntityRandom {

    private final EasyRandom easyRandom;
    private final EntityManager entityManager;
    private final ReflectionHelper reflectionHelper;

    public <T extends AbstractEntity> T nextSaved(Class<T> baseClass) {
        var newEntity = next(baseClass);
        return entityManager.merge(newEntity);
    }

    public <T extends AbstractEntity> T nextSaved(
        Class<T> baseClass,
        Map<String, Object> properties
    ) {
        var newEntity = next(baseClass);

        reflectionHelper.invokeSetters(newEntity, properties);

        return entityManager.merge(newEntity);
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
        var obj = easyRandom.nextObject(baseClass);
        obj.setId(null);

        // TODO: 30/06/2021 Lidar com variáveis OneToMany sendo setadas

        return obj;
    }

}
