package ru.dias.homebudget.action;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.dias.homebudget.persistence.entities.Income;
import ru.dias.homebudget.persistence.entities.TypeIncome;
import ru.dias.homebudget.persistence.repositories.TypeIncomeRepository;
import ru.dias.homebudget.services.IncomeService;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class ActionIncome implements BudgetAction {

    private final IncomeService incomeService;
    private final TypeIncomeRepository typeIncomeRepository;

    @Override
    public String action(ActionContext context) {

        TypeIncome typeIncome = typeIncomeRepository.findOneByName(context.getType());

        Income income = Income.builder()
                .typeIncome(typeIncome)
                .date(context.getDate())
                .participant(context.getParticipant())
                .amount(context.getAmount())
                .build();

        incomeService.save(income);

        return "A receipt for the amount of " + context.getAmount() + " is recorded.";
    }
}
