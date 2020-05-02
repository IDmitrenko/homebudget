package ru.dias.homebudget.persistence.entities;

import lombok.*;
import ru.dias.homebudget.persistence.entities.utils.PersistableEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "income")
@EqualsAndHashCode(callSuper = true)
public class Income extends PersistableEntity {

    private Date date;

    private double amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_income_id")
    private TypeIncome typeIncome;

}
