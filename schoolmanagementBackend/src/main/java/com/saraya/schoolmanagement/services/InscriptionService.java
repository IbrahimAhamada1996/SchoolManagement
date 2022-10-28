package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Inscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InscriptionService {
    Inscription findById(Long id) throws ResourceNotFoundException;

    Inscription saveInscription(Inscription inscription);

    Inscription updateInscription(Inscription inscription);

    void deleteInscriptionById(Long id) throws  ResourceNotFoundException;

    List<Inscription> findAllInscriptions();
    Page<Inscription> findAllInscriptions(Pageable pageable);

    void deleteAllInscriptions();

    boolean isInscriptionExist(Inscription inscription);
}
