package org.moneymatters.crm.exception;

import org.moneymatters.crm.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class UserExceptionHandle {
//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException exception){
//        return new ResponseEntity<>(new ErrorDetails(new Date(), exception.getMessage()), HttpStatus.NOT_FOUND);
//    }
//    @ExceptionHandler(UserAlreadyExistsException.class)
//    public ResponseEntity<ErrorDetails> handleUserAlreadyExistsException(UserAlreadyExistsException exception){
//        return new ResponseEntity<>(new ErrorDetails(new Date(), exception.getMessage()), HttpStatus.BAD_REQUEST);
//    }
//    @ExceptionHandler(ValidationException.class)
//    public ResponseEntity<ErrorDetails> handleValidationException(ValidationException exception){
//        return new ResponseEntity<>(new ErrorDetails(new Date(), exception.getMessage()), HttpStatus.BAD_REQUEST);
//    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception){
        return new ResponseEntity<>(new ErrorDetails(new Date(), exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
