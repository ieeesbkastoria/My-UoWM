package gr.ieee.cs.uowm.myuowm_admin_panel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AppExceptionHandler {

    // BAD REQUEST - 400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException e) {
        Exception exception = new Exception(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    // UNAUTHORIZED - 401
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Object> handleBadRequestException(UnauthorizedException e) {
        Exception exception = new Exception(
                e.getMessage(),
                e,
                HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(exception, HttpStatus.UNAUTHORIZED);
    }
    
    // FORBIDDEN - 403
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<Object> handleForbiddenException(ForbiddenException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.FORBIDDEN
        );
        return new ResponseEntity<>(exception, HttpStatus.FORBIDDEN);
    }

    // NOT FOUND - 404
    @ExceptionHandler(value=NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    // METHOD NOT ALLOWED - 405
    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<Object> handleMethodNotAllowedException(MethodNotAllowedException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.METHOD_NOT_ALLOWED
        );
        return new ResponseEntity<>(exception, HttpStatus.METHOD_NOT_ALLOWED);
    }

    // PAYLOAD TOO LARGE - 413
    @ExceptionHandler(PayloadTooLargeException.class)
    public ResponseEntity<Object> handlePayloadTooLargeException(PayloadTooLargeException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.PAYLOAD_TOO_LARGE
        );
        return new ResponseEntity<>(exception, HttpStatus.PAYLOAD_TOO_LARGE);
    }

    // TOO MANY REQUESTS - 429
    @ExceptionHandler(TooManyRequestsException.class)
    public ResponseEntity<Object> handleTooManyRequestsException(TooManyRequestsException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.TOO_MANY_REQUESTS
        );
        return new ResponseEntity<>(exception, HttpStatus.TOO_MANY_REQUESTS);
    }

    // INTERNAL SERVER ERROR - 500
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<Object> handleInternalServerErrorException(InternalServerErrorException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.INTERNAL_SERVER_ERROR
        );
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // SERVICE UNAVAILABLE - 503
    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<Object> handleServiceUnavailableException(ServiceUnavailableException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.SERVICE_UNAVAILABLE
        );
        return new ResponseEntity<>(exception, HttpStatus.SERVICE_UNAVAILABLE);
    }

    // GATEWAY TIMEOUT - 504
    @ExceptionHandler(GatewayTimeoutException.class)
    public ResponseEntity<Object> handleGatewayTimeoutException(GatewayTimeoutException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.GATEWAY_TIMEOUT
        );
        return new ResponseEntity<>(exception, HttpStatus.GATEWAY_TIMEOUT);
    }

    
}
