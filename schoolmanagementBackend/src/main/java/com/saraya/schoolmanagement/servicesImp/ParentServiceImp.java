package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Parent;
import com.saraya.schoolmanagement.repositories.ParentRepository;
import com.saraya.schoolmanagement.services.ParentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImp implements ParentService {
    private final ParentRepository parentRepository;

    public ParentServiceImp(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public Parent findById(Long id) throws ResourceNotFoundException {
        Optional<Parent> parent = this.parentRepository.findParentById(id);
        if (!parent.isPresent())
            throw new ResourceNotFoundException("Parent not available");
        return parent.get();
    }

    @Override
    public Parent saveParent(Parent parent) {
        parent.setCreatedAt(LocalDateTime.now());
        return this.parentRepository.save(parent);
    }

    @Override
    public Parent updateParent(Parent parent) {
        parent.setUpdatedAt(LocalDateTime.now());
        return this.parentRepository.save(parent);
    }

    @Override
    public void deleteParentById(Long id) throws ResourceNotFoundException {
        if(!this.parentRepository.existsParentById(id))
            throw new ResourceNotFoundException("Impossible to delete Parent");
        else
            this.parentRepository.deleteById(id);
    }

    @Override
    public List<Parent> findAllParents() {
        return this.parentRepository.findAll();
    }

    @Override
    public Page<Parent> findAllParents(Pageable pageable) {
        return this.parentRepository.findAll(pageable);
    }

    @Override
    public void deleteAllParents() {
        this.parentRepository.deleteAll();
    }

    @Override
    public boolean isParentExist(Parent parent) {
        return false;
    }
}
