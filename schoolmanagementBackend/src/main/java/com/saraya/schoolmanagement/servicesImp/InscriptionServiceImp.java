package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Inscription;
import com.saraya.schoolmanagement.repositories.InscriptionRepository;
import com.saraya.schoolmanagement.services.InscriptionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InscriptionServiceImp implements InscriptionService {
    private final InscriptionRepository inscriptionRepository;

    public InscriptionServiceImp(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public Inscription findById(Long id) throws ResourceNotFoundException {
        Optional<Inscription> inscription = this.inscriptionRepository.findInscriptionById(id);
        if(!inscription.isPresent())
            throw new ResourceNotFoundException("Inscription not available");
        return inscription.get();
    }

    @Override
    public Inscription saveInscription(Inscription inscription) {
        inscription.setCreatedAt(LocalDateTime.now());
        return this.inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        inscription.setUpdatedAt(LocalDateTime.now());
        return this.inscriptionRepository.save(inscription);
    }

    @Override
    public void deleteInscriptionById(Long id) throws ResourceNotFoundException {
        if (!this.inscriptionRepository.existsInscriptionById(id))
            throw new ResourceNotFoundException("Impossible to delete this Insciption");
        else
            this.inscriptionRepository.deleteById(id);
    }

    @Override
    public List<Inscription> findAllInscriptions() {
        return this.inscriptionRepository.findAll();
    }

    @Override
    public Page<Inscription> findAllInscriptions(Pageable pageable) {
        return this.inscriptionRepository.findAll(pageable);
    }

    @Override
    public void deleteAllInscriptions() {
        this.inscriptionRepository.deleteAll();
    }

    @Override
    public boolean isInscriptionExist(Inscription inscription) {
        return false;
    }
}
