package ru.dias.homebudget.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dias.homebudget.persistence.entities.Income;

import java.util.List;
import java.util.UUID;

@Repository
public interface IncomeRepository extends JpaRepository<Income, UUID> {
    List<Income> findAll();
}