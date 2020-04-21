package ru.dias.homebudget.persistence.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.dias.homebudget.persistence.entities.utils.PersistableEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "expense")
@EqualsAndHashCode(callSuper = true)
public class Expense extends PersistableEntity {

    private Date date;

    private double amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_expense_id")
    private TypeExpense typeExpense;

    private String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "long_term_goal_id")
    private LongTermGoal longTermGoal;

}
