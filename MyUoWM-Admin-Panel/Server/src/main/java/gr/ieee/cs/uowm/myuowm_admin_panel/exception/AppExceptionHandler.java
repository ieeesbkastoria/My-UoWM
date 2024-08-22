package gr.ieee.cs.uowm.myuowm_admin_panel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AppExceptionHandler {

    // BAD REQUEST - 400
    @SLF4J
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException e) {
        Exception exception = new Exception(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST);
        log.error("Bad Request (400) Exception: " + e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    // UNAUTHORIZED - 401
    @SLF4J
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Object> handleBadRequestException(UnauthorizedException e) {
        Exception exception = new Exception(
                e.getMessage(),
                e,
                HttpStatus.UNAUTHORIZED);
        log.error("Unauthorized (401) Exception: " + e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.UNAUTHORIZED);
    }
    
    // FORBIDDEN - 403
    @SLF4J
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<Object> handleForbiddenException(ForbiddenException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.FORBIDDEN
        );
        log.error("Forbidden (403) Exception: " + e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.FORBIDDEN);
    }

    // NOT FOUND - 404
    @SLF4J
    @ExceptionHandler(value=NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.NOT_FOUND
        );
        log.error("Not Found (404) Exception: " + e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    // METHOD NOT ALLOWED - 405
    @SLF4J
    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<Object> handleMethodNotAllowedException(MethodNotAllowedException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.METHOD_NOT_ALLOWED
        );
        log.error("Method Not Allowed (405) Exception: " + e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.METHOD_NOT_ALLOWED);
    }

    // PAYLOAD TOO LARGE - 413
    @SLF4J
    @ExceptionHandler(PayloadTooLargeException.class)
    public ResponseEntity<Object> handlePayloadTooLargeException(PayloadTooLargeException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.PAYLOAD_TOO_LARGE
        );
        log.error("Payload Too Large (413) Exception: " + e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.PAYLOAD_TOO_LARGE);
    }

    // TOO MANY REQUESTS - 429
    @SLF4J
    @ExceptionHandler(TooManyRequestsException.class)
    public ResponseEntity<Object> handleTooManyRequestsException(TooManyRequestsException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.TOO_MANY_REQUESTS
        );
        log.error("Too Many Requests (429) Exception: " + e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.TOO_MANY_REQUESTS);
    }

    // INTERNAL SERVER ERROR - 500
    @SLF4J
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<Object> handleInternalServerErrorException(InternalServerErrorException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.INTERNAL_SERVER_ERROR
        );
        log.error("Internal Server Error (500) Exception: " + e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // SERVICE UNAVAILABLE - 503
    @SLF4J
    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<Object> handleServiceUnavailableException(ServiceUnavailableException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.SERVICE_UNAVAILABLE
        );
        log.error("Service Unavailable (503) Exception: " + e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.SERVICE_UNAVAILABLE);
    }

    // GATEWAY TIMEOUT - 504
    @SLF4J
    @ExceptionHandler(GatewayTimeoutException.class)
    public ResponseEntity<Object> handleGatewayTimeoutException(GatewayTimeoutException e) {
        Exception exception = new Exception(
            e.getMessage(),
            e,
            HttpStatus.GATEWAY_TIMEOUT
        );
        log.error("Gateway Timeout (504) Exception: " + e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.GATEWAY_TIMEOUT);
    }
    
}
