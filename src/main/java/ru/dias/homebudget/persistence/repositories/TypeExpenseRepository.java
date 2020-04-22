package ru.dias.homebudget.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dias.homebudget.persistence.entities.TypeExpense;

import java.util.UUID;

@Repository
public interface TypeExpenseRepository extends JpaRepository<TypeExpense, UUID> {

    TypeExpense findOneByName(String name);
}