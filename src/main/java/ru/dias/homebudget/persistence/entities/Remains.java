package ru.dias.homebudget.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dias.homebudget.persistence.entities.utils.PersistableEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "remains")
public class Remains extends PersistableEntity {

    private Date date;

    private double amount;

}
