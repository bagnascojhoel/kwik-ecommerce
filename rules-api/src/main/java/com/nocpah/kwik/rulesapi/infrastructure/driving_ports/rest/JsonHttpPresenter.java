package com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest;

import com.nocpah.kwik.rulesapi.common.presenter.AbstractHttpPresenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonHttpPresenter<T> extends AbstractHttpPresenter<T> {
    @Override
    protected HashMap<String, List<String>> defaultHeaders() {
        return new HashMap<>(Map.of("content-type", List.of("application/json")));
    }
}
