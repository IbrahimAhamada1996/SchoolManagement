package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Level;
import com.saraya.schoolmanagement.repositories.LevelRepository;
import com.saraya.schoolmanagement.services.LevelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImp implements LevelService {
    private final LevelRepository levelRepository;

    public LevelServiceImp(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public Level findById(Long id) throws ResourceNotFoundException {
        Optional<Level> level = this.levelRepository.findLevelById(id);
        if (!level.isPresent())
            throw new ResourceNotFoundException("Level not available");
        return level.get();
    }

    @Override
    public Level saveLevel(Level level) {
        return this.levelRepository.save(level);
    }

    @Override
    public Level updateLevel(Level level) {
        return this.levelRepository.save(level);
    }

    @Override
    public void deleteLevelById(Long id) throws ResourceNotFoundException {
        if (!this.levelRepository.existsLevelById(id))
            throw new ResourceNotFoundException("Impossible to delete this Level");
        else
            this.levelRepository.deleteById(id);
    }

    @Override
    public List<Level> findAllLevels() {
        return this.levelRepository.findAll();
    }

    @Override
    public Page<Level> findAllLevels(Pageable pageable) {
        return this.levelRepository.findAll(pageable);
    }

    @Override
    public void deleteAllLevels() {
        this.levelRepository.deleteAll();
    }

    @Override
    public boolean isLevelExist(Level level) {
        return false;
    }
}
