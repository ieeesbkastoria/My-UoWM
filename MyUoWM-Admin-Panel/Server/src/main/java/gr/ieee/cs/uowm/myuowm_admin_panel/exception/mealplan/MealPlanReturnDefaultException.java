package gr.ieee.cs.uowm.myuowm_admin_panel.exception.mealplan;

public class MealPlanReturnDefaultException extends RuntimeException{
    public MealPlanReturnDefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public MealPlanReturnDefaultException(String message) {
        super(message);
    }
}
