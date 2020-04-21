package ru.dias.homebudget.persistence.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.dias.homebudget.persistence.entities.utils.PersistableEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "participant")
@EqualsAndHashCode(callSuper = true)
public class Participant extends PersistableEntity {

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

}
