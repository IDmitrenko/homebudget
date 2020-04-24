package ru.dias.homebudget.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dias.homebudget.persistence.entities.Income;
import ru.dias.homebudget.persistence.entities.Remains;
import ru.dias.homebudget.persistence.repositories.RemainsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RemainsService {

    private final RemainsRepository remainsRepository;

    public List<Remains> findAll() {
        return remainsRepository.findAll();
    }
}
