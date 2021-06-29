package br.com.kwikecommerce.api.code.random;

import lombok.RequiredArgsConstructor;
import org.jeasy.random.EasyRandom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class RandomObject {

    private final EasyRandom easyRandom;

    public <T> Page<T> nextPage(Class<T> baseClass) {
        return new PageImpl<>(nextList(baseClass));
    }

    public <T> List<T> nextList(Class<T> baseClass) {
        return nextList(baseClass, 1);
    }

    public <T> List<T> nextList(Class<T> baseClass, long qty) {
        var result = new ArrayList<T>();

        for (long i = 0; i < qty; i++)
            result.add(next(baseClass));

        return result;
    }

    public <T, R> List<R> nextList(Class<T> baseClass, Class<R> resultClass) {
        return nextList(baseClass, resultClass, 1);
    }

    public <T, R> List<R> nextList(Class<T> baseClass, Class<R> resultClass, long qty) {
        var result = new ArrayList<R>();

        for (long i = 0; i < qty; i++)
            result.add(resultClass.cast(next(baseClass)));

        return result;
    }

    public <T> T next(Class<T> baseClass) {
        return easyRandom.nextObject(baseClass);
    }

}
