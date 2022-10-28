package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.ModuleDto;
import com.saraya.schoolmanagement.models.Module;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.ModuleMapper;
import com.saraya.schoolmanagement.services.ModuleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping(value = "/modules")
public class ModuleController {

    private final ModuleService moduleService;

    private final ModuleMapper moduleMapper;

    public ModuleController(ModuleService moduleService, ModuleMapper moduleMapper) {
        this.moduleService = moduleService;
        this.moduleMapper = moduleMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createModule(@RequestBody ModuleDto moduleDto){

        Module module =  moduleService.saveModule(moduleMapper.dtoToModel(moduleDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(moduleMapper.modelToDto(module));
    }
    
    @GetMapping
    public ResponseEntity<List<ModuleDto>> findAll(){
      List<Module> modules =  moduleService.findAllModules();
      if (modules.isEmpty()){
          return new ResponseEntity<List<ModuleDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<ModuleDto>>( moduleMapper.modelsToDtos(modules), HttpStatus.OK);
    }

    /*@GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Module> modules = new ArrayList<Module>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Module> modulePage = moduleService.findAllModules(pageable);
        modules = modulePage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("modules",moduleMapper.modelsToDtos(modules));
        response.put("currentPage",modulePage.getNumber());
        response.put("totalItems",modulePage.getTotalElements());
        response.put("totalPages",modulePage.getTotalPages());
        if (modules.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<ModuleDto> findModuleById(@PathVariable Long id) throws ResourceNotFoundException {
        ModuleDto moduleDto = moduleMapper.modelToDto(moduleService.findById(id));
        if (moduleDto == null || id ==null) {
            return new ResponseEntity<ModuleDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ModuleDto>(moduleDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<ModuleDto> updateModuleById(@RequestBody ModuleDto moduleDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<ModuleDto>(HttpStatus.NO_CONTENT);
        }
        Module module =  this.moduleService.updateModule(this.moduleMapper.dtoToModel(moduleDto));
        return new ResponseEntity<ModuleDto>(this.moduleMapper.modelToDto(module), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteModuleById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        moduleService.deleteModuleById(id);
        return ResponseEntity.noContent().build();
    }
}
