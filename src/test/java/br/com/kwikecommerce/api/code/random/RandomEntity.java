package br.com.kwikecommerce.api.code.random;

import br.com.kwikecommerce.api.domain.AbstractEntity;
import lombok.RequiredArgsConstructor;
import org.jeasy.random.EasyRandom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class RandomEntity {

    private final EasyRandom easyRandom;

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

        return obj;
    }

}
