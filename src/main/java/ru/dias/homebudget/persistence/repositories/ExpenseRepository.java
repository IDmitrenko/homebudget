package ru.dias.homebudget.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dias.homebudget.persistence.entities.Expense;

import java.util.UUID;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, UUID> {
}