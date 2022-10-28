package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.SchoolCareerDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.SchoolCarrerMapper;
import com.saraya.schoolmanagement.models.SchoolCareer;
import com.saraya.schoolmanagement.services.SchoolCareerService;
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
@RequestMapping(value = "/school-careers")
public class SchoolCareerController {

    private final SchoolCareerService schoolCareerService;

    private final SchoolCarrerMapper schoolCareerMapper;

    public SchoolCareerController(SchoolCareerService schoolCareerService, SchoolCarrerMapper schoolCareerMapper) {
        this.schoolCareerService = schoolCareerService;
        this.schoolCareerMapper = schoolCareerMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createSchoolCareer(@RequestBody SchoolCareerDto schoolCareerDto){
        SchoolCareer schoolCareer =  schoolCareerService.saveSchoolCareer(schoolCareerMapper.dtoToModel(schoolCareerDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(schoolCareerMapper.modelToDto(schoolCareer));
    }

    @GetMapping
    public ResponseEntity<List<SchoolCareerDto>> findAll(){
      List<SchoolCareer> schoolCareers =  schoolCareerService.findAllSchoolCareers();
      if (schoolCareers.isEmpty()){
          return new ResponseEntity<List<SchoolCareerDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<SchoolCareerDto>>( schoolCareerMapper.modelsToDtos(schoolCareers), HttpStatus.OK);
    }

   /* @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<SchoolCareer> schoolCareers = new ArrayList<SchoolCareer>();
        Pageable pageable = PageRequest.of(page, size);
        Page<SchoolCareer> schoolCareerPage = schoolCareerService.findAllSchoolCareers(pageable);
        schoolCareers = schoolCareerPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("schoolCareers",schoolCareerMapper.modelsToDtos(schoolCareers));
        response.put("currentPage",schoolCareerPage.getNumber());
        response.put("totalItems",schoolCareerPage.getTotalElements());
        response.put("totalPages",schoolCareerPage.getTotalPages());
        if (schoolCareers.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<SchoolCareerDto> findSchoolCareerById(@PathVariable Long id) throws ResourceNotFoundException {
        SchoolCareerDto schoolCareerDto = schoolCareerMapper.modelToDto(schoolCareerService.findById(id));
        if (schoolCareerDto == null || id ==null) {
            return new ResponseEntity<SchoolCareerDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<SchoolCareerDto>(schoolCareerDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<SchoolCareerDto> updateSchoolCareerById(@RequestBody SchoolCareerDto schoolCareerDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<SchoolCareerDto>(HttpStatus.NO_CONTENT);
        }
        SchoolCareer schoolCareer =  this.schoolCareerService.updateSchoolCareer(this.schoolCareerMapper.dtoToModel(schoolCareerDto));
        return new ResponseEntity<SchoolCareerDto>(this.schoolCareerMapper.modelToDto(schoolCareer), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSchoolCareerById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        schoolCareerService.deleteSchoolCareerById(id);
        return ResponseEntity.noContent().build();
    }
}
