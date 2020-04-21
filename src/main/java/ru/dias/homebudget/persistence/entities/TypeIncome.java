package ru.dias.homebudget.persistence.entities;

import lombok.*;
import ru.dias.homebudget.persistence.entities.utils.PersistableEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "type_income")
@EqualsAndHashCode(callSuper = true)
public class TypeIncome extends PersistableEntity {

    private String name;

}
