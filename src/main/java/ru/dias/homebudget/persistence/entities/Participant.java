package ru.dias.homebudget.persistence.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.dias.homebudget.persistence.entities.enums.Role;
import ru.dias.homebudget.persistence.entities.utils.PersistableEntity;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "participant")
@EqualsAndHashCode(callSuper = true)
public class Participant extends PersistableEntity {

    private String login;

    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;
}
