package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Establishment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EstablishmentService {
    Establishment findById(Long id) throws ResourceNotFoundException;

    Establishment saveEstablishment(Establishment establishment);

    Establishment updateEstablishment(Establishment establishment);

    void deleteEstablishmentById(Long id) throws  ResourceNotFoundException;

    List<Establishment> findAllEstablishments();
    Page<Establishment> findAllEstablishments(Pageable pageable);

    void deleteAllEstablishments();

    boolean isEstablishmentExist(Establishment establishment);
}
