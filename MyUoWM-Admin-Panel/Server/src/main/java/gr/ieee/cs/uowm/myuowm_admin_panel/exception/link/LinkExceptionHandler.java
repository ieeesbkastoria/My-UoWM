package gr.ieee.cs.uowm.myuowm_admin_panel.exception.link;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Link;
import gr.ieee.cs.uowm.myuowm_admin_panel.exception.mealplan.MealPlanReturnDefaultException;
import gr.ieee.cs.uowm.myuowm_admin_panel.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class LinkExceptionHandler {

    private static List<Link> defaultLinkList;

    public LinkExceptionHandler() {
        //TODO initialize defaultLinkList
    }

    @ExceptionHandler(value = {LinkNotFoundException.class})
    public ResponseEntity<Object> linkNotFoundExceptionHandler
            (LinkNotFoundException linkNotFoundException)
    {
        LinkException linkException = new LinkException(
                linkNotFoundException.getMessage(),
                linkNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(linkException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {LinkReturnDefaultException.class})
    public ResponseEntity<Object> mealPlanExceptionHandler
            (LinkReturnDefaultException linkReturnDefaultException)
    {
        LinkException linkException = new LinkException(
                linkReturnDefaultException.getMessage(),
                linkReturnDefaultException.getCause(),
                HttpStatus.OK
        );

        return ResponseHandler.responseBuilder(linkException.getMessage(), HttpStatus.NOT_FOUND, defaultLinkList);
    }
}
