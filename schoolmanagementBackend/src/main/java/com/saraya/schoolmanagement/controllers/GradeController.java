package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.GradeDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.GradeMapper;
import com.saraya.schoolmanagement.models.Grade;
import com.saraya.schoolmanagement.services.GradeService;
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
@RequestMapping(value = "/grades")
public class GradeController {

    private final GradeService gradeService;

    private final GradeMapper gradeMapper;

    public GradeController(GradeService gradeService, GradeMapper gradeMapper) {
        this.gradeService = gradeService;
        this.gradeMapper = gradeMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createGrade(@RequestBody GradeDto gradeDto){
        Grade grade =  gradeService.saveGrade(gradeMapper.dtoToModel(gradeDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(gradeMapper.modelToDto(grade));
    }
    
    @GetMapping
    public ResponseEntity<List<GradeDto>> findAll(){
      List<Grade> grades =  gradeService.findAllGrades();
      if (grades.isEmpty()){
          return new ResponseEntity<List<GradeDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<GradeDto>>( gradeMapper.modelsToDtos(grades), HttpStatus.OK);
    }

   /* @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Grade> grades = new ArrayList<Grade>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Grade> gradePage = gradeService.findAllGrades(pageable);
        grades = gradePage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("grades",gradeMapper.modelsToDtos(grades));
        response.put("currentPage",gradePage.getNumber());
        response.put("totalItems",gradePage.getTotalElements());
        response.put("totalPages",gradePage.getTotalPages());
        if (grades.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<GradeDto> findGradeById(@PathVariable Long id) throws ResourceNotFoundException {
        GradeDto gradeDto = gradeMapper.modelToDto(gradeService.findById(id));
        if (gradeDto == null || id ==null) {
            return new ResponseEntity<GradeDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<GradeDto>(gradeDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<GradeDto> updateGradeById(@RequestBody GradeDto gradeDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<GradeDto>(HttpStatus.NO_CONTENT);
        }
        Grade grade =  this.gradeService.updateGrade(this.gradeMapper.dtoToModel(gradeDto));
        return new ResponseEntity<GradeDto>(this.gradeMapper.modelToDto(grade), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGradeById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        gradeService.deleteGradeById(id);
        return ResponseEntity.noContent().build();
    }
}
