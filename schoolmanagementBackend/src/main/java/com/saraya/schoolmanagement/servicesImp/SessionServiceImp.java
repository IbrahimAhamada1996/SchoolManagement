package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Session;
import com.saraya.schoolmanagement.repositories.SessionRepository;
import com.saraya.schoolmanagement.services.SessionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  SessionServiceImp implements SessionService {
    private final SessionRepository sessionRepository;

    public SessionServiceImp(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public Session findById(Long id) throws ResourceNotFoundException {
        Optional<Session> session = this.sessionRepository.findSessionById(id);
        if(!session.isPresent())
            throw new ResourceNotFoundException("Session not available");
        return session.get();
    }

    @Override
    public Session saveSession(Session session) {

        return this.sessionRepository.save(session);
    }

    @Override
    public Session updateSession(Session session) {
        return this.sessionRepository.save(session);
    }

    @Override
    public void deleteSessionById(Long id) throws ResourceNotFoundException {
        if (!this.sessionRepository.existsSessionById(id))
            throw new ResourceNotFoundException("Impossible to delete this Session");
        else
            this.sessionRepository.deleteById(id);
    }

    @Override
    public List<Session> findAllSessions() {
        return this.sessionRepository.findAll();
    }

    @Override
    public Page<Session> findAllSessions(Pageable pageable) {
        return this.sessionRepository.findAll(pageable);
    }

    @Override
    public void deleteAllSessions() {
        this.sessionRepository.deleteAll();
    }

    @Override
    public boolean isSessionExist(Session session) {
        return false;
    }
}
