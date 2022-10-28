package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Establishment;
import com.saraya.schoolmanagement.repositories.EstablishmentRepository;
import com.saraya.schoolmanagement.services.EstablishmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstablishmentServiceImp implements EstablishmentService {
    private final EstablishmentRepository establishmentRepository;

    public EstablishmentServiceImp(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    @Override
    public Establishment findById(Long id) throws ResourceNotFoundException {
        Optional<Establishment> establishment = this.establishmentRepository.findEstablishmentById(id);
        if (!establishment.isPresent())
            throw new ResourceNotFoundException("Establishment not available");
        return establishment.get();
    }

    @Override
    public Establishment saveEstablishment(Establishment establishment) {

        return this.establishmentRepository.save(establishment);
    }

    @Override
    public Establishment updateEstablishment(Establishment establishment) {
        return this.establishmentRepository.save(establishment);
    }

    @Override
    public void deleteEstablishmentById(Long id) throws ResourceNotFoundException {
        if(this.establishmentRepository.existsEstablishmentById(id))
            throw new ResourceNotFoundException("Impossible to delete this Establishment");
        else
            this.establishmentRepository.deleteById(id);
    }

    @Override
    public List<Establishment> findAllEstablishments() {
        return this.establishmentRepository.findAll();
    }

    @Override
    public Page<Establishment> findAllEstablishments(Pageable pageable) {
        return this.establishmentRepository.findAll(pageable);
    }

    @Override
    public void deleteAllEstablishments() {
        this.establishmentRepository.deleteAll();
    }

    @Override
    public boolean isEstablishmentExist(Establishment establishment) {
        return false;
    }
}
