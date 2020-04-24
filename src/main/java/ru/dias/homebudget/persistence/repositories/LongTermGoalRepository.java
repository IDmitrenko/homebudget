package ru.dias.homebudget.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dias.homebudget.persistence.entities.LongTermGoal;

import java.util.UUID;

@Repository
public interface LongTermGoalRepository extends JpaRepository<LongTermGoal, UUID> {

    LongTermGoal findOneByName(String name);
}