package com.nocpah.kwik.rulesapi.common.presenter;

public interface FailPresenter<T> extends Presenter<T> {
    void onFail(T value);
}
