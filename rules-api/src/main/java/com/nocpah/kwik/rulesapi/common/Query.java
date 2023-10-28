package com.nocpah.kwik.rulesapi.common;

public interface Query<I, P> {
    default void query(P presenter) {
        this.query(null, presenter);
    }

    void query(I input, P presenter);
}
