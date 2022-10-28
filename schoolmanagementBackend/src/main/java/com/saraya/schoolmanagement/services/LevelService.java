package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LevelService {
    Level findById(Long id) throws ResourceNotFoundException;

    Level saveLevel(Level level);

    Level updateLevel(Level level);

    void deleteLevelById(Long id) throws  ResourceNotFoundException;

    List<Level> findAllLevels();
    Page<Level> findAllLevels(Pageable pageable);

    void deleteAllLevels();

    boolean isLevelExist(Level level);
}
