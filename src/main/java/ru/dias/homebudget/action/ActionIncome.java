package ru.dias.homebudget.action;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.dias.homebudget.persistence.entities.Income;
import ru.dias.homebudget.persistence.entities.Participant;
import ru.dias.homebudget.persistence.entities.TypeIncome;
import ru.dias.homebudget.persistence.repositories.ParticipantRepository;
import ru.dias.homebudget.persistence.repositories.TypeIncomeRepository;
import ru.dias.homebudget.services.IncomeService;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class ActionIncome implements BudgetAction {

    private final IncomeService incomeService;
    private final TypeIncomeRepository typeIncomeRepository;
    private final ParticipantRepository participantRepository;

    @Override
    public String action(ActionContext context) {

        TypeIncome typeIncome = typeIncomeRepository.findOneByName(context.getType());
        Participant participant = participantRepository.findOneByLogin(context.getParticipant());

        Income income = Income.builder()
                .typeIncome(typeIncome)
                .date(context.getDate())
                .participant(participant)
                .amount(context.getAmount())
                .build();

        incomeService.save(income);

        return "A receipt for the amount of " + context.getAmount() + " is recorded.";
    }
}
