package main.exception.club;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClubExceptionHandler {

    @ExceptionHandler(ClubNotFoundException.class)
    public ResponseEntity<Object> clubNotFoundExceptionHandler
            (ClubNotFoundException clubNotFoundException)
    {
        ClubException clubException = new ClubException(
                clubNotFoundException.getMessage(),
                clubNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(clubException, HttpStatus.NOT_FOUND);
    }
}
