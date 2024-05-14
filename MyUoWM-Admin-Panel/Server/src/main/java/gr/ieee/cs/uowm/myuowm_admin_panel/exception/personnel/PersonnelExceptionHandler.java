package gr.ieee.cs.uowm.myuowm_admin_panel.exception.personnel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonnelExceptionHandler {

    @ExceptionHandler(value = {PersonnelNotFoundException.class})
    public ResponseEntity<Object> personnelNotFoundResponse
            (PersonnelNotFoundException personnelNotFoundException)
    {
        PersonnelException personnelException = new PersonnelException(
                personnelNotFoundException.getMessage(),
                personnelNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(personnelException, HttpStatus.NOT_FOUND);
    }
}
