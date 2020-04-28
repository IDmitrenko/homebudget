package ru.dias.homebudget.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.dias.homebudget.action.ActionContext;
import ru.dias.homebudget.persistence.repositories.RemainsRepository;
import ru.dias.homebudget.strategy.ExpenseValidationStrategy;

@Component
@Profile("plus")
@RequiredArgsConstructor
public class ExpenseValidationPlus implements ExpenseValidationStrategy {

    private final RemainsRepository remainsRepository;

    @Override
    public boolean validate(ActionContext context) {
        // проверка на положительный остаток
        if ((remainsRepository.obtainAmountByDate(context.getDate()) - context.getAmount()) >= 0) {
            return true;
        }
        return false;
    }
}
