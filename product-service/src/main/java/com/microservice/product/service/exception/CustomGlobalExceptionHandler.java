package com.microservice.product.service.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductException.class)
    protected  ResponseEntity<CustomErrorResponse> handlePasswordException(ProductException ex) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setTimestamp(LocalDateTime.now());
        customErrorResponse.setError(ex.getMessage());
        customErrorResponse.setDebugMessage(ex.getStackTrace()[0]);
        return ResponseEntity.ok(customErrorResponse);
    }
}
