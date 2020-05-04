package ru.dias.homebudget.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dias.homebudget.persistence.entities.Remains;
import ru.dias.homebudget.persistence.repositories.RemainsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RemainsService {

    private final RemainsRepository remainsRepository;

    public List<Remains> findAll() {
        return remainsRepository.findAll();
    }
}
