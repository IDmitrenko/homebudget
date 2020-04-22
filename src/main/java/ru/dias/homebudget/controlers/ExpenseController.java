package ru.dias.homebudget.controlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dias.homebudget.action.ActionContext;
import ru.dias.homebudget.action.BudgetActionFactory;
import ru.dias.homebudget.persistence.dto.ExpenseDto;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(name = "/expense")
public class ExpenseController {

    private final BudgetActionFactory actionFactory;

    public String addExpense(ExpenseDto expenseDto, HttpSession session) {
        String message = actionFactory.createAction(BudgetActionFactory.BudgetActionType.EXPENSE)
                .action(new ActionContext()
                .builder()
                .type(expenseDto.getTypeExpense().getName())
                .participant(expenseDto.getParticipant())
                .date(expenseDto.getDate())
                .amount(expenseDto.getAmount())
                .comment(expenseDto.getComment())
                .longTermGoal(expenseDto.getLongTermGoal().getName())
                .build()
                );
        log.info(message);

        return "expense";
    }

}
