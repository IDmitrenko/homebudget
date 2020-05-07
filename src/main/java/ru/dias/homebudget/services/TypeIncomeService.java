package ru.dias.homebudget.services;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dias.homebudget.persistence.entities.Income;
import ru.dias.homebudget.persistence.entities.TypeIncome;
import ru.dias.homebudget.persistence.repositories.TypeIncomeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@CacheConfig(cacheNames = {"typeIncome"})
@RequiredArgsConstructor
public class TypeIncomeService {

    @PersistenceContext
    private EntityManager entityManager;

    private final TypeIncomeRepository typeIncomeRepository;

    @Transactional
    public void save(TypeIncome typeIncome) {

        typeIncomeRepository.save(typeIncome);
    }

    @Cacheable
    public List<TypeIncome> findAll() {
        return typeIncomeRepository.findAll();
    }

    public TypeIncome findOneByName(String name) {
        return typeIncomeRepository.findOneByName(name);
    }
}
