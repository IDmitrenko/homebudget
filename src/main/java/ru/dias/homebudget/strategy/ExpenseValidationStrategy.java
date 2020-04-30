package ru.dias.homebudget.strategy;

import ru.dias.homebudget.action.ActionContext;

public interface ExpenseValidationStrategy {

    boolean validate(ActionContext context);
}
