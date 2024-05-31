package main.exception.mealplan;

public class MealPlanReturnDefaultException extends RuntimeException{
    public MealPlanReturnDefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public MealPlanReturnDefaultException(String message) {
        super(message);
    }
}
