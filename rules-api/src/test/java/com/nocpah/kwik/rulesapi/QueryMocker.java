package com.nocpah.kwik.rulesapi;

import com.nocpah.kwik.rulesapi.common.Query;
import com.nocpah.kwik.rulesapi.common.presenter.EmptySuccessPresenter;
import com.nocpah.kwik.rulesapi.common.presenter.FailPresenter;
import com.nocpah.kwik.rulesapi.common.presenter.Presenter;
import com.nocpah.kwik.rulesapi.common.presenter.SuccessPresenter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.function.Consumer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class QueryMocker {

    public static <I, O, P extends Presenter<O>> StubbedQuery<I, O, P> when(Query<I, P> aQuery) {
        return new StubbedQuery<>(aQuery);
    }

    @RequiredArgsConstructor
    public static class StubbedQuery<I, O, P extends Presenter<O>> {
        private final Query<I, P> query;

        public StubbedQueryExecution<I, O, P> withoutInput() {
            return new StubbedQueryExecution<>(this.query, null);
        }

        public StubbedQueryExecution<I, O, P> with(I anInput) {
            return new StubbedQueryExecution<>(this.query, anInput);
        }
    }

    @RequiredArgsConstructor
    public static class StubbedQueryExecution<I, O, P extends Presenter<O>> {
        private final Query<I, P> query;
        private final I input;

        public void thenPresent(Consumer<P> presenterAction) {
            this.doAnswer(invocation -> {
                presenterAction.accept(this.presenter(invocation));
                return null;
            });
        }

        public void thenOnSuccess(O output) {
            this.doAnswer(invocation -> {
                var presenter = this.presenter(invocation);
                if (presenter instanceof SuccessPresenter<?>) {
                    ((SuccessPresenter<O>) presenter).onSuccess(output);
                } else {
                    this.throwUnsupportedPresentation(presenter, "onSuccess");
                }
                return null;
            });
        }

        public void thenOnSuccess() {
            this.doAnswer(invocation -> {
                var presenter = this.presenter(invocation);
                if (presenter instanceof SuccessPresenter<?>) {
                    ((EmptySuccessPresenter) presenter).onSuccess();
                } else {
                    this.throwUnsupportedPresentation(presenter, "onSuccess");
                }
                return null;
            });
        }

        public void thenOnFail(O output) {
            this.doAnswer(invocation -> {
                var presenter = this.presenter(invocation);
                if (presenter instanceof SuccessPresenter<?>) {
                    ((FailPresenter<O>) presenter).onFail(output);
                } else {
                    this.throwUnsupportedPresentation(presenter, "onFail");
                }
                return null;
            });
        }

        private void doAnswer(Answer<O> anAnswer) {
            Mockito.doAnswer(anAnswer).when(this.query).query(eq(this.input), any());
            Mockito.doAnswer(anAnswer).when(this.query).query(any());
        }

        private P presenter(InvocationOnMock invocation) {
            var lastArgumentIndex = invocation.getArguments().length - 1;
            return invocation.getArgument(lastArgumentIndex);
        }

        private void throwUnsupportedPresentation(P presenter, String methodName) {
            var message = "Presenter '%s' does not support '%s' presentation.".formatted(
                    presenter.getClass().getName(),
                    methodName
            );
            throw new IllegalStateException(message);
        }
    }

}
