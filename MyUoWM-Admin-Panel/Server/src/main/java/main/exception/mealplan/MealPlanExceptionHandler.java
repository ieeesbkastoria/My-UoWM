package main.exception.mealplan;

import main.datasource.model.MealPlan;
import main.response.ResponseHandler;
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
        MealPlanException mealPlanException = new MealPlanException(
                mealPlanReturnDefaultException.getMessage(),
                mealPlanReturnDefaultException.getCause(),
                HttpStatus.OK
        );

        return ResponseHandler.responseBuilder(mealPlanException.getMessage(), HttpStatus.NOT_FOUND, defaultMealPlan);
    }
}
