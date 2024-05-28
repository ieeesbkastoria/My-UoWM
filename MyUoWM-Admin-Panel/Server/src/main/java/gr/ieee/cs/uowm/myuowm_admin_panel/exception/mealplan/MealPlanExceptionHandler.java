package gr.ieee.cs.uowm.myuowm_admin_panel.exception.mealplan;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.exception.link.LinkException;
import gr.ieee.cs.uowm.myuowm_admin_panel.exception.link.LinkNotFoundException;
import gr.ieee.cs.uowm.myuowm_admin_panel.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class MealPlanExceptionHandler {

    private static final List<MealPlan> defaultMealPlan = Collections.EMPTY_LIST; //TODO

    public MealPlanExceptionHandler() {
        //TODO initialize default meal plan
    }

    @ExceptionHandler(value = {MealPlanReturnDefaultException.class})
    public ResponseEntity<Object> mealPlanExceptionHandler
            (MealPlanReturnDefaultException mealPlanReturnDefaultException)
    {
        LinkException linkException = new LinkException(
                mealPlanReturnDefaultException.getMessage(),
                mealPlanReturnDefaultException.getCause(),
                HttpStatus.OK
        );

        return ResponseHandler.responseBuilder(linkException.getMessage(), HttpStatus.NOT_FOUND, defaultMealPlan);
    }
}
