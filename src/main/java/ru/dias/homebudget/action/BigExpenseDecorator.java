package ru.dias.homebudget.action;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class BigExpenseDecorator implements BudgetAction {

    private final ActionExpense actionExpense;
    private final double ALERT_AMOUNT = 10000.0;

    @Override
    public String action(ActionContext context) {
        if (context.getAmount() > ALERT_AMOUNT) {
            log.warn("Внимание. Сумма затрат превышает порог!" + context.toString());
        }
        return actionExpense.action(context);
    }

}
