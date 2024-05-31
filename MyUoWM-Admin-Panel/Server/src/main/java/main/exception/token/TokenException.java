package main.exception.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class TokenException {
    private final String message;
    private final Throwable cause;
    private final HttpStatus httpStatus;
}
