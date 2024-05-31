package main.exception.link;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class LinkException {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
}
