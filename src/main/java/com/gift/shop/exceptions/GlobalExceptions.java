package com.gift.shop.exceptions;

import com.gift.shop.exceptions.nullexception.MissingDetailsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptions<T> extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MissingDetailsException.class)
    public ResponseEntity<T> DetailMissingException() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("date", LocalDateTime.now());
        body.put("message", new MissingDetailsException().getMessage());
        body.put("code", HttpStatus.FORBIDDEN.value());
        return new ResponseEntity<T>((T) body, HttpStatus.BAD_GATEWAY);

    }

}
