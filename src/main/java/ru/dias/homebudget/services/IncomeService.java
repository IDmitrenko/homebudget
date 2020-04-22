package ru.dias.homebudget.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dias.homebudget.persistence.entities.Income;
import ru.dias.homebudget.persistence.repositories.IncomeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeService {

    @PersistenceContext
    private EntityManager entityManager;

    private final IncomeRepository incomeRepository;

    @Transactional
    public void save(Income income) {

        incomeRepository.save(income);
    }

    public List<Income> findAll() {
        return incomeRepository.findAll();
    }
}
