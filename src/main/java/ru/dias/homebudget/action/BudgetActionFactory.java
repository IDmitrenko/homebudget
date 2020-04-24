package ru.dias.homebudget.action;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BudgetActionFactory {

    private final ActionExpense actionExpense;
    private final ActionIncome actionIncome;

    public BudgetAction createAction(BudgetActionType type){
        switch (type){
            case INCOME:
                return actionExpense;
            case EXPENSE:
                return actionIncome;
        }
        throw new RuntimeException("Unknown type");
    }


    public enum BudgetActionType{
        INCOME,
        EXPENSE
    }
}
