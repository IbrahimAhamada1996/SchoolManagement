package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SessionService {
    Session findById(Long id) throws ResourceNotFoundException;

    Session saveSession(Session session);

    Session updateSession(Session session);

    void deleteSessionById(Long id) throws  ResourceNotFoundException;

    List<Session> findAllSessions();
    Page<Session> findAllSessions(Pageable pageable);

    void deleteAllSessions();

    boolean isSessionExist(Session session);
}
