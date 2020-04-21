package ru.dias.homebudget.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dias.homebudget.persistence.entities.Participant;
import ru.dias.homebudget.persistence.entities.enums.Role;
import ru.dias.homebudget.persistence.repositories.ParticipantRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ParticipantService implements UserDetailsService {

    private final ParticipantRepository participantRepository;

    public Participant findByLogin(String login) {
        return participantRepository.findOneByLogin(login);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Participant participant = participantRepository.findOneByLogin(username);
        if (participant == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new User(participant.getLogin(), participant.getPassword(), mapRolesToAuthorities(participant.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Role role) {
        return role != null ?
                new ArrayList<GrantedAuthority>() {{ add((GrantedAuthority) role::name); }} :
                new ArrayList<>();
    }

    public boolean isUserExist(String login) {
        return participantRepository.existsByLogin(login);
    }

}