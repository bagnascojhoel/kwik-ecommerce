package com.nocpah.kwik.rulesapi.common.presenter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMapAdapter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractHttpPresenter<T> {
    private ResponseEntity<T> responseEntity;

    public ResponseEntity<T> present() {
        Assert.notNull(this.responseEntity, "Cannot present without a response entity set");
        return this.responseEntity;
    }

    protected ResponseBuilder<T> responseBuilder() {
        return new ResponseBuilder<>(this, this.defaultHeaders());
    }

    abstract protected HashMap<String, List<String>> defaultHeaders();

    protected static final class ResponseBuilder<T> {
        private final Map<String, List<String>> headers;
        private final AbstractHttpPresenter<T> presenter;
        private T body;
        private HttpStatus status;

        public ResponseBuilder(AbstractHttpPresenter<T> presenter, Map<String, List<String>> headers) {
            this.presenter = presenter;
            this.headers = headers;
        }

        public ResponseBuilder<T> status(HttpStatus httpStatus) {
            this.status = httpStatus;
            return this;
        }

        public ResponseBuilder<T> body(T body) {
            this.body = body;
            return this;
        }

        public ResponseBuilder<T> header(String key, String... value) {
            this.headers.put(key, Arrays.asList(value));
            return this;
        }

        public void build() {
            this.presenter.responseEntity = new ResponseEntity<>(body, new MultiValueMapAdapter<>(headers), status);
        }
    }
}
