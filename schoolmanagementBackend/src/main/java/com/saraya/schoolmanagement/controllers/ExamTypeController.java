package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.ExamTypeDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.ExamTypeMapper;
import com.saraya.schoolmanagement.models.ExamType;
import com.saraya.schoolmanagement.services.ExamTypeService;
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
@RequestMapping(value = "/exam-types")
public class ExamTypeController {
    private final ExamTypeService examTypeService;

    private final ExamTypeMapper examTypeMapper;

    public ExamTypeController(ExamTypeService examTypeService, ExamTypeMapper examTypeMapper) {
        this.examTypeService = examTypeService;
        this.examTypeMapper = examTypeMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createExamType(@RequestBody ExamTypeDto examTypeDto){

        ExamType examType =  examTypeService.saveExamType(examTypeMapper.dtoToModel(examTypeDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(examTypeMapper.modelToDto(examType));
    }
    
    @GetMapping
    public ResponseEntity<List<ExamTypeDto>> findAll(){
      List<ExamType> examTypes =  examTypeService.findAllExamTypes();
      if (examTypes.isEmpty()){
          return new ResponseEntity<List<ExamTypeDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<ExamTypeDto>>( examTypeMapper.modelsToDtos(examTypes), HttpStatus.OK);
    }

    /*@GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<ExamType> examTypes = new ArrayList<ExamType>();
        Pageable pageable = PageRequest.of(page, size);
        Page<ExamType> examTypePage = examTypeService.findAllExamTypes(pageable);
        examTypes = examTypePage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("examTypes",examTypeMapper.modelsToDtos(examTypes));
        response.put("currentPage",examTypePage.getNumber());
        response.put("totalItems",examTypePage.getTotalElements());
        response.put("totalPages",examTypePage.getTotalPages());
        if (examTypes.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<ExamTypeDto> findExamTypeById(@PathVariable Long id) throws ResourceNotFoundException {
        ExamTypeDto examTypeDto = examTypeMapper.modelToDto(examTypeService.findById(id));
        if (examTypeDto == null || id ==null) {
            return new ResponseEntity<ExamTypeDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ExamTypeDto>(examTypeDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<ExamTypeDto> updateExamTypeById(@RequestBody ExamTypeDto examTypeDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<ExamTypeDto>(HttpStatus.NO_CONTENT);
        }
        ExamType examType =  this.examTypeService.updateExamType(this.examTypeMapper.dtoToModel(examTypeDto));
        return new ResponseEntity<ExamTypeDto>(this.examTypeMapper.modelToDto(examType), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExamTypeById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        examTypeService.deleteExamTypeById(id);
        return ResponseEntity.noContent().build();
    }
}
