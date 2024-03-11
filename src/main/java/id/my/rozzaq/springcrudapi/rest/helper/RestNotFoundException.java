package id.my.rozzaq.springcrudapi.rest.helper;

public class RestNotFoundException extends RuntimeException {
    public RestNotFoundException(String message) {
        super(message);
    }

    public RestNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestNotFoundException(Throwable cause) {
        super(cause);
    }
}
