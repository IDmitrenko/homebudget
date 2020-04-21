package ru.dias.homebudget.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dias.homebudget.persistence.entities.Participant;

import java.util.UUID;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, UUID> {
    Participant findOneByLogin(String login);
    boolean existsByLogin(String login);
}