package ru.dias.homebudget.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dias.homebudget.persistence.entities.TypeIncome;

import java.util.UUID;

@Repository
public interface TypeIncomeRepository extends JpaRepository<TypeIncome, UUID> {

    TypeIncome findOneByName(String name);
}