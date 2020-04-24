package ru.dias.homebudget.action;

import lombok.*;
import ru.dias.homebudget.persistence.entities.LongTermGoal;
import ru.dias.homebudget.persistence.entities.Participant;
import ru.dias.homebudget.persistence.entities.TypeExpense;
import ru.dias.homebudget.persistence.entities.TypeIncome;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActionContext {

    private Date date;

    private double amount;

    private Participant participant;

    private String type;

    private String comment;

    private String longTermGoal;

}
