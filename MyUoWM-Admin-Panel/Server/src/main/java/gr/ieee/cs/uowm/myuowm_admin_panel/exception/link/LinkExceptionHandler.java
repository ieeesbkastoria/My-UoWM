package gr.ieee.cs.uowm.myuowm_admin_panel.exception.link;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionHandler {

    @SLF4J
    @ExceptionHandler(value = {LinkNotFoundException.class})
    public ResponseEntity<Object> linkNotFoundExceptionHandler
            (LinkNotFoundException linkNotFoundException)
    {
        LinkException linkException = new LinkException(
                linkNotFoundException.getMessage(),
                linkNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        log.error("Link Not Found (404) Exception: " + linkNotFoundException.getMessage());
        return new ResponseEntity<>(linkException, HttpStatus.NOT_FOUND);
    }
}
