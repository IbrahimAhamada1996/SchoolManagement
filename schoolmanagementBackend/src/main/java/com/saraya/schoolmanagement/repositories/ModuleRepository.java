package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Module;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModuleRepository extends CrudRepository<Module,Long> {
    Optional<Module> findModuleById(Long id);
    List<Module> findAll();
    Page<Module> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsModuleById(Long id);
}
