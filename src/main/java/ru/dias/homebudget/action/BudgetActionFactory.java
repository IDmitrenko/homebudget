package ru.dias.homebudget.action;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BudgetActionFactory {

    private final BigExpenseDecorator actionExpense;
    private final ActionIncome actionIncome;

    public BudgetAction createAction(BudgetActionType type){
        switch (type){
            case INCOME:
                return actionIncome;
            case EXPENSE:
                return actionExpense;
        }
        throw new RuntimeException("Unknown type");
    }


    public enum BudgetActionType{
        INCOME,
        EXPENSE
    }
}
