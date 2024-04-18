package gr.ieee.cs.uowm.myuowm_admin_panel.exception;

public class MethodNotAllowedException extends RuntimeException{
    public MethodNotAllowedException(String message) {
        super(message);
    }

    public MethodNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }
}
