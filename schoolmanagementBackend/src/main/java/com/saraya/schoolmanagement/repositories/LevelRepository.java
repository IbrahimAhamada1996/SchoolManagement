package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LevelRepository extends CrudRepository<Level,Long> {
    Optional<Level> findLevelById(Long id);
    List<Level> findAll();
    Page<Level> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsLevelById(Long id);
}
