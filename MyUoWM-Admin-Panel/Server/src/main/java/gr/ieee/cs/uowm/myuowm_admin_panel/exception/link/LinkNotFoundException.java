package gr.ieee.cs.uowm.myuowm_admin_panel.exception.link;

public class LinkNotFoundException extends RuntimeException{
    public LinkNotFoundException(String message) {
        super(message);
    }

    public LinkNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
