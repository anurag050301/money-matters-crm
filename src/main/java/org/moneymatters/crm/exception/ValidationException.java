package org.moneymatters.crm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ValidationException extends RuntimeException {
    public ValidationException(String message){
        super(message);
    }
}
