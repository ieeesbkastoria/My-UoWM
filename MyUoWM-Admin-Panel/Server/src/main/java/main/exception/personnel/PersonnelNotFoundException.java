package main.exception.personnel;


public class PersonnelNotFoundException extends RuntimeException {

    public PersonnelNotFoundException(String message) {
        super(message);
    }

    public PersonnelNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
