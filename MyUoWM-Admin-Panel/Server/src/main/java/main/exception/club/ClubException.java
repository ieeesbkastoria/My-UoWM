package main.exception.club;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ClubException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
}
