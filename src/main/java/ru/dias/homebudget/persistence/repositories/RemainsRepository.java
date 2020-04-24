package ru.dias.homebudget.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.dias.homebudget.persistence.entities.Remains;

import java.util.Date;
import java.util.UUID;

@Repository
public interface RemainsRepository extends JpaRepository<Remains, UUID> {

    @Query(value = "SELECT remains.amount FROM remains WHERE date = :date", nativeQuery = true)
    Double obtainAmountByDate(@Param("date")Date date);
}