package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends CrudRepository<Session,Long> {
    Optional<Session> findSessionById(Long id);
    List<Session> findAll();
    Page<Session> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsSessionById(Long id);
}
