package io.bootify.my_oracle_app.error;

import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.TimeoutException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpServerErrorException.class)
    protected ResponseEntity<Object> handleHttpServerErrorException(HttpServerErrorException ex,
                                                                    HttpServletRequest request,
                                                                    HttpServletResponse response) {
        String body = ex.getResponseBodyAsString();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(FeignException.InternalServerError.class)
    protected ResponseEntity<Object> handleFeignExceptionInternalServerError(FeignException ex,
                                                          HttpServletRequest request,
                                                          HttpServletResponse response) {
        String body = ex.contentUTF8();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(FeignException.BadRequest.class)
    protected ResponseEntity<Object> handleFeignException(FeignException ex,
                                                          HttpServletRequest request,
                                                          HttpServletResponse response) {
        String body = ex.contentUTF8();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(TimeoutException.class)
    protected ResponseEntity<Object> handleTimeoutExceptio(TimeoutException ex,
                                                           HttpServletRequest request,
                                                           HttpServletResponse response) {
        String body = ex.getMessage();
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(body);
    }
}

