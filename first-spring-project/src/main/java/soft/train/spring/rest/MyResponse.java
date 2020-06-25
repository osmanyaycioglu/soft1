package soft.train.spring.rest;

public class MyResponse<T> {

    private boolean       errorOccured;
    private MyErrorObject error;
    private T             response;

    public static <E> MyResponse<E> of(final E response) {
        final MyResponse<E> e = new MyResponse<>();
        e.response = response;
        e.errorOccured = false;
        return e;
    }

    public boolean isErrorOccured() {
        return this.errorOccured;
    }

    public void setErrorOccured(final boolean errorOccuredParam) {
        this.errorOccured = errorOccuredParam;
    }

    public MyErrorObject getError() {
        return this.error;
    }

    public void setError(final MyErrorObject errorParam) {
        this.error = errorParam;
    }

    public T getResponse() {
        return this.response;
    }

    public void setResponse(final T responseParam) {
        this.response = responseParam;
    }
}
