package com.saraya.schoolmanagement.servicesImp;
import com.saraya.schoolmanagement.models.Module;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.repositories.ModuleRepository;
import com.saraya.schoolmanagement.services.ModuleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleServiceImp implements ModuleService {
    private final ModuleRepository moduleRepository;

    public ModuleServiceImp(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public Module findById(Long id) throws ResourceNotFoundException {
        Optional<Module> module = this.moduleRepository.findModuleById(id);
        if (!module.isPresent())
            throw new ResourceNotFoundException("Module not available");
        return module.get();
    }

    @Override
    public Module saveModule(Module module) {
        return this.moduleRepository.save(module);
    }

    @Override
    public Module updateModule(Module module) {
        return this.moduleRepository.save(module);
    }

    @Override
    public void deleteModuleById(Long id) throws ResourceNotFoundException {
        if(!this.moduleRepository.existsModuleById(id))
            throw new ResourceNotFoundException("Impossible to delete module");
        else
            this.moduleRepository.deleteById(id);
    }

    @Override
    public List<Module> findAllModules() {
        return this.moduleRepository.findAll();
    }

    @Override
    public Page<Module> findAllModules(Pageable pageable) {
        return this.moduleRepository.findAll(pageable);
    }

    @Override
    public void deleteAllModules() {
        this.moduleRepository.deleteAll();
    }

    @Override
    public boolean isModuleExist(Module module) {
        return false;
    }
}
