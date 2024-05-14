package gr.ieee.cs.uowm.myuowm_admin_panel.exception.club;

public class ClubNotFoundException extends RuntimeException {

    public ClubNotFoundException(String message) {
        super(message);
    }

    public ClubNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
