package com.example.Online.Banking.System.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = EmailAlreadyExistsException.class)
    public ResponseEntity<Object> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception) {
        HttpStatus conflict = HttpStatus.CONFLICT;

        ApiException apiException =  new ApiException(
                exception.getMessage(),
                conflict,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return  new ResponseEntity<>(apiException, conflict);
    }

    @ExceptionHandler(value = IdNotFoundException.class)
    public ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException exception) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;

        ApiException apiException =  new ApiException(
                exception.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return  new ResponseEntity<>(apiException, notFound);
    }

    @ExceptionHandler(value = AccountNotFoundException.class)
    public ResponseEntity<Object> handleIdAccountNotFoundException(AccountNotFoundException exception) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;

        ApiException apiException =  new ApiException(
                exception.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return  new ResponseEntity<>(apiException, notFound);
    }
}
