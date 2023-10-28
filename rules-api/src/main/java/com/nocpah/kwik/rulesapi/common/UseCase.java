package com.nocpah.kwik.rulesapi.common;

public interface UseCase<I, P> {
    void execute(I input, P presenter);
}
