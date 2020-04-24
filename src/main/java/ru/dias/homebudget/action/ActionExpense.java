package ru.dias.homebudget.action;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.dias.homebudget.persistence.entities.Expense;
import ru.dias.homebudget.persistence.entities.LongTermGoal;
import ru.dias.homebudget.persistence.entities.TypeExpense;
import ru.dias.homebudget.persistence.repositories.LongTermGoalRepository;
import ru.dias.homebudget.persistence.repositories.RemainsRepository;
import ru.dias.homebudget.persistence.repositories.TypeExpenseRepository;
import ru.dias.homebudget.services.ExpenseService;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class ActionExpense implements BudgetAction {

    private final ExpenseService expenseService;
    private final TypeExpenseRepository typeExpenseRepository;
    private final LongTermGoalRepository longTermGoalRepository;
    private final RemainsRepository remainsRepository;

    @Override
    public String action(ActionContext context) {

// проверка на положительный остаток
        if ((remainsRepository.obtainAmountByDate(context.getDate()) - context.getAmount()) >= 0) {

            TypeExpense typeExpense = typeExpenseRepository.findOneByName(context.getType());
            LongTermGoal longTermGoal = longTermGoalRepository.findOneByName(context.getLongTermGoal());

            Expense expense = Expense.builder()
                    .typeExpense(typeExpense)
                    .participant(context.getParticipant())
                    .date(context.getDate())
                    .amount(context.getAmount())
                    .comment(context.getComment())
                    .longTermGoal(longTermGoal)
                    .build();

            expenseService.save(expense);

            return "An expense of " + context.getAmount() + " is allowed and fixed.";
        }
        return "There are not enough funds to perform the operation.";
    }
}
