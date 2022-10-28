package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Inscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InscriptionRepository extends CrudRepository<Inscription,Long> {
    Optional<Inscription> findInscriptionById(Long id);
    List<Inscription> findAll();
    Page<Inscription> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsInscriptionById(Long id);
}
