package br.com.etec.exception;

public class RequestTimeout extends RuntimeException {
    public RequestTimeout() {
    }

    public RequestTimeout(String message) {
        super(message);
    }

    public RequestTimeout(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestTimeout(Throwable cause) {
        super(cause);
    }
}
