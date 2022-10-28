package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.FacultyDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.FacultyMapper;
import com.saraya.schoolmanagement.models.Faculty;
import com.saraya.schoolmanagement.services.FacultyService;
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
@RequestMapping(value = "/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    private final FacultyMapper facultyMapper;

    public FacultyController(FacultyService facultyService, FacultyMapper facultyMapper) {
        this.facultyService = facultyService;
        this.facultyMapper = facultyMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createFaculty(@RequestBody FacultyDto facultyDto){
        Faculty faculty =  facultyService.saveFaculty(facultyMapper.dtoToModel(facultyDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(facultyMapper.modelToDto(faculty));
    }
    
    @GetMapping
    public ResponseEntity<List<FacultyDto>> findAll(){
      List<Faculty> facultys =  facultyService.findAllFacultys();
      if (facultys.isEmpty()){
          return new ResponseEntity<List<FacultyDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<FacultyDto>>( facultyMapper.modelsToDtos(facultys), HttpStatus.OK);
    }

    /*@GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Faculty> facultys = new ArrayList<Faculty>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Faculty> facultyPage = facultyService.findAllFacultys(pageable);
        facultys = facultyPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("facultys",facultyMapper.modelsToDtos(facultys));
        response.put("currentPage",facultyPage.getNumber());
        response.put("totalItems",facultyPage.getTotalElements());
        response.put("totalPages",facultyPage.getTotalPages());
        if (facultys.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<FacultyDto> findFacultyById(@PathVariable Long id) throws ResourceNotFoundException {
        FacultyDto facultyDto = facultyMapper.modelToDto(facultyService.findById(id));
        if (facultyDto == null || id ==null) {
            return new ResponseEntity<FacultyDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<FacultyDto>(facultyDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<FacultyDto> updateFacultyById(@RequestBody FacultyDto facultyDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<FacultyDto>(HttpStatus.NO_CONTENT);
        }
        Faculty faculty =  this.facultyService.updateFaculty(this.facultyMapper.dtoToModel(facultyDto));
        return new ResponseEntity<FacultyDto>(this.facultyMapper.modelToDto(faculty), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFacultyById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        facultyService.deleteFacultyById(id);
        return ResponseEntity.noContent().build();
    }
}
