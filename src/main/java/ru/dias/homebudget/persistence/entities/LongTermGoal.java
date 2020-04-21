package ru.dias.homebudget.persistence.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.dias.homebudget.persistence.entities.utils.PersistableEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "long_term_goal")
@EqualsAndHashCode(callSuper = true)
public class LongTermGoal extends PersistableEntity {

    private String name;

    @Column(name = "estimated_cost")
    private double estimatedCost;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "monthly_amount")
    private double monthlyAmount;

}
