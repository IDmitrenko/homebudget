package ru.dias.homebudget.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HomeBudgetNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public HomeBudgetNotFoundException(String message) {
        super(message);
    }

}