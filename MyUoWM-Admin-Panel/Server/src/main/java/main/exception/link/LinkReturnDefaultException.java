package main.exception.link;

public class LinkReturnDefaultException extends RuntimeException{

    public LinkReturnDefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinkReturnDefaultException(String message) {
        super(message);
    }
}
