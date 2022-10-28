package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.models.Module;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ModuleService {
    Module findById(Long id) throws ResourceNotFoundException;

    Module saveModule(Module module);

    Module updateModule(Module module);

    void deleteModuleById(Long id) throws  ResourceNotFoundException;

    List<Module> findAllModules();
    Page<Module> findAllModules(Pageable pageable);

    void deleteAllModules();

    boolean isModuleExist(Module module);
}
