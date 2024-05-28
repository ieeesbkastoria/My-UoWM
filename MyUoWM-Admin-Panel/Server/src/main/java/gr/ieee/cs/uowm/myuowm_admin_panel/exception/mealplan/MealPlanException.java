package gr.ieee.cs.uowm.myuowm_admin_panel.exception.mealplan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class MealPlanException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
}
