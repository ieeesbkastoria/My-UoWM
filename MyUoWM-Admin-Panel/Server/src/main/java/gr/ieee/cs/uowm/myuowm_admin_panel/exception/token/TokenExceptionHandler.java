package gr.ieee.cs.uowm.myuowm_admin_panel.exception.token;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TokenExceptionHandler {

    @ExceptionHandler(value = {TokenNotFoundException.class})
    public ResponseEntity<Object> tokenNotFoundResponse
            (TokenNotFoundException tokenNotFoundException)
    {
        TokenException tokenException = new TokenException(
                tokenNotFoundException.getMessage(),
                tokenNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(tokenException, HttpStatus.NOT_FOUND);
    }
}
