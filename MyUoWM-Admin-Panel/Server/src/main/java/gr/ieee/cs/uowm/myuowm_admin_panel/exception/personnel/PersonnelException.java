package gr.ieee.cs.uowm.myuowm_admin_panel.exception.personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class PersonnelException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
}
