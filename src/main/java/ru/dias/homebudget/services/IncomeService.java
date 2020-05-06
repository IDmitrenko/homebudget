package ru.dias.homebudget.services;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dias.homebudget.persistence.entities.Income;
import ru.dias.homebudget.persistence.repositories.IncomeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = {"listIncomeCache"})
public class IncomeService {

    @PersistenceContext
    private EntityManager entityManager;

    private final IncomeRepository incomeRepository;

    @Transactional
    @CacheEvict(allEntries = true)
    public Income save(Income income) {

        return incomeRepository.save(income);
    }

    @Cacheable
    public List<Income> findAll() {
        return incomeRepository.findAll();
    }
}
