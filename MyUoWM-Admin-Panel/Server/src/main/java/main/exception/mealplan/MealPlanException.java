package main.exception.mealplan;

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
