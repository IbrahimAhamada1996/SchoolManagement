package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Establishment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstablishmentRepository extends CrudRepository<Establishment,Long> {
    Optional<Establishment> findEstablishmentById(Long id);
    List<Establishment> findAll();
    Page<Establishment> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsEstablishmentById(Long id);
}
