package ru.dias.homebudget.controlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.dias.homebudget.exceptions.HomeBudgetInternalServerException;
import ru.dias.homebudget.exceptions.HomeBudgetNotFoundException;

@Slf4j
@ControllerAdvice
public class ShopExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HomeBudgetNotFoundException.class)
    public String handleProductNotFoundException(Model model, final HomeBudgetNotFoundException ex) {
        log.error("Product not found thrown", ex);
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(HomeBudgetInternalServerException.class)
    public String handleHomeBudgetInternalServerError(Model model, final HomeBudgetInternalServerException ex) {
        log.error("Internal Server Error", ex);
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }
}