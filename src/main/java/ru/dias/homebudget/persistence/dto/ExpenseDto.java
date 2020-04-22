package ru.dias.homebudget.persistence.dto;

import lombok.Builder;
import lombok.Data;
import ru.dias.homebudget.persistence.entities.LongTermGoal;
import ru.dias.homebudget.persistence.entities.Participant;
import ru.dias.homebudget.persistence.entities.TypeExpense;

import java.util.Date;

@Data
@Builder
public class ExpenseDto {

    private TypeExpense typeExpense;
    private Date date;
    private Participant participant;
    private Double amount;
    private String comment;
    private LongTermGoal longTermGoal;

}
