package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.EmployeeDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.EmployeeMapper;
import com.saraya.schoolmanagement.models.Employee;;
import com.saraya.schoolmanagement.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }


    @PostMapping
    public ResponseEntity<?>
    createEmployee(@RequestBody EmployeeDto employeeDto){

        Employee employee =  employeeService.saveEmployee(employeeMapper.dtoToModel(employeeDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeMapper.modelToDto(employee));
    }
    
   @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll(){
      List<Employee> employees =  employeeService.findAllEmployees();
      if (employees.isEmpty()){
          return new ResponseEntity<List<EmployeeDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<EmployeeDto>>( employeeMapper.modelsToDtos(employees), HttpStatus.OK);
    }

    /* @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Employee> employees = new ArrayList<Employee>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employeePage = employeeService.findAllEmployees(pageable);
        employees = employeePage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("employees",employeeMapper.modelsToDtos(employees));
        response.put("currentPage",employeePage.getNumber());
        response.put("totalItems",employeePage.getTotalElements());
        response.put("totalPages",employeePage.getTotalPages());
        if (employees.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
        EmployeeDto employeeDto = employeeMapper.modelToDto(employeeService.findById(id));
        if (employeeDto == null || id ==null) {
            return new ResponseEntity<EmployeeDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@RequestBody EmployeeDto employeeDto,@PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<EmployeeDto>(HttpStatus.NO_CONTENT);
        }
       Employee employee =  this.employeeService.updateEmployee(this.employeeMapper.dtoToModel(employeeDto));
        return new ResponseEntity<EmployeeDto>(this.employeeMapper.modelToDto(employee), HttpStatus.OK);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }
}
