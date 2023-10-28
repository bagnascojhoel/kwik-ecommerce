package com.nocpah.kwik.rulesapi.common.presenter;

public interface SuccessPresenter<T> extends Presenter<T> {
    void onSuccess(T value);
}
