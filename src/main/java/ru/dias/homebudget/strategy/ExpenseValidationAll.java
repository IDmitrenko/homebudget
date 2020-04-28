package ru.dias.homebudget.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.dias.homebudget.action.ActionContext;
import ru.dias.homebudget.strategy.ExpenseValidationStrategy;

@Component
@RequiredArgsConstructor
@Profile("all")
public class ExpenseValidationAll implements ExpenseValidationStrategy {
    @Override
    public boolean validate(ActionContext context) {
        return true;
    }
}
