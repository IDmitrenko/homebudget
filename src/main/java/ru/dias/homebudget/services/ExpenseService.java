package ru.dias.homebudget.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dias.homebudget.persistence.entities.Expense;
import ru.dias.homebudget.persistence.repositories.ExpenseRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    @PersistenceContext
    private EntityManager entityManager;

    private final ExpenseRepository expenseRepository;

    @Transactional
    public void save(Expense expense) {

        expenseRepository.save(expense);
    }
}
