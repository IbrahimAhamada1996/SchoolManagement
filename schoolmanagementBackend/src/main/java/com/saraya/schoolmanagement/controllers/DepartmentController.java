package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.DepartmentDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.DepartmentMapper;
import com.saraya.schoolmanagement.models.Department;
import com.saraya.schoolmanagement.services.DepartmentService;
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
@RequestMapping(value = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    private final DepartmentMapper departmentMapper;

    public DepartmentController(DepartmentService departmentService, DepartmentMapper departmentMapper) {
        this.departmentService = departmentService;
        this.departmentMapper = departmentMapper;
    }


    @PostMapping
    public ResponseEntity<?>
    createDepartment(@RequestBody DepartmentDto departmentDto){

        Department department =  departmentService.saveDepartment(departmentMapper.dtoToModel(departmentDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentMapper.modelToDto(department));
    }
    
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> findAll(){
      List<Department> departments =  departmentService.findAllDepartments();
      if (departments.isEmpty()){
          return new ResponseEntity<List<DepartmentDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<DepartmentDto>>( departmentMapper.modelsToDtos(departments), HttpStatus.OK);
    }

    /*@GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Department> departments = new ArrayList<Department>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Department> departmentPage = departmentService.findAllDepartments(pageable);
        departments = departmentPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("departments",departmentMapper.modelsToDtos(departments));
        response.put("currentPage",departmentPage.getNumber());
        response.put("totalItems",departmentPage.getTotalElements());
        response.put("totalPages",departmentPage.getTotalPages());
        if (departments.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> findDepartmentById(@PathVariable Long id) throws ResourceNotFoundException {
        DepartmentDto departmentDto = departmentMapper.modelToDto(departmentService.findById(id));
        if (departmentDto == null || id ==null) {
            return new ResponseEntity<DepartmentDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartmentById(@RequestBody DepartmentDto departmentDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<DepartmentDto>(HttpStatus.NO_CONTENT);
        }
        Department department =  this.departmentService.updateDepartment(this.departmentMapper.dtoToModel(departmentDto));
        return new ResponseEntity<DepartmentDto>(this.departmentMapper.modelToDto(department), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartmentById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        departmentService.deleteDepartmentById(id);
        return ResponseEntity.noContent().build();
    }
}
