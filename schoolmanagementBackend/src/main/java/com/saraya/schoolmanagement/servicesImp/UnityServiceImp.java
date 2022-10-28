package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Unity;
import com.saraya.schoolmanagement.repositories.UnityRepository;
import com.saraya.schoolmanagement.services.UnityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnityServiceImp implements UnityService {
    private final UnityRepository unityRepository;

    public UnityServiceImp(UnityRepository unityRepository) {
        this.unityRepository = unityRepository;
    }

    @Override
    public Unity findById(Long id) throws ResourceNotFoundException {
        Optional<Unity> unity = this.unityRepository.findUnityById(id);
        if (!unity.isPresent())
            throw new ResourceNotFoundException("Unity not available");
        return unity.get();
    }

    @Override
    public Unity saveUnity(Unity unity) {
        return this.unityRepository.save(unity);
    }

    @Override
    public Unity updateUnity(Unity unity) {
        return this.unityRepository.save(unity);
    }

    @Override
    public void deleteUnityById(Long id) throws ResourceNotFoundException {
        if (!unityRepository.existsUnityById(id))
            throw new ResourceNotFoundException("Impossible to delete this Unity");
        else
            this.unityRepository.deleteById(id);
    }

    @Override
    public List<Unity> findAllUnitys() {
        return this.unityRepository.findAll();
    }

    @Override
    public Page<Unity> findAllUnitys(Pageable pageable) {
        return this.unityRepository.findAll(pageable);
    }

    @Override
    public void deleteAllUnitys() {
        this.unityRepository.deleteAll();
    }

    @Override
    public boolean isUnityExist(Unity unity) {
        return false;
    }
}
