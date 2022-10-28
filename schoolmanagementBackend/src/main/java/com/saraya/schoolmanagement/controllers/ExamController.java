package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.ExamDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.ExamMapper;
import com.saraya.schoolmanagement.models.Exam;
import com.saraya.schoolmanagement.services.ExamService;
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
@RequestMapping(value = "/exams")
public class ExamController {
    private final ExamService examService;

    private final ExamMapper examMapper;

    public ExamController(ExamService examService, ExamMapper examMapper) {
        this.examService = examService;
        this.examMapper = examMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createExam(@RequestBody ExamDto examDto){
        Exam exam =  examService.saveExam(examMapper.dtoToModel(examDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(examMapper.modelToDto(exam));
    }
    
   @GetMapping
    public ResponseEntity<List<ExamDto>> findAll(){
      List<Exam> exams =  examService.findAllExams();
      if (exams.isEmpty()){
          return new ResponseEntity<List<ExamDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<ExamDto>>( examMapper.modelsToDtos(exams), HttpStatus.OK);
    }

   /* @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Exam> exams = new ArrayList<Exam>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Exam> examPage = examService.findAllExams(pageable);
        exams = examPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("exams",examMapper.modelsToDtos(exams));
        response.put("currentPage",examPage.getNumber());
        response.put("totalItems",examPage.getTotalElements());
        response.put("totalPages",examPage.getTotalPages());
        if (exams.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<ExamDto> findExamById(@PathVariable Long id) throws ResourceNotFoundException {
        ExamDto examDto = examMapper.modelToDto(examService.findById(id));
        if (examDto == null || id ==null) {
            return new ResponseEntity<ExamDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ExamDto>(examDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<ExamDto> updateExamById(@RequestBody ExamDto examDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<ExamDto>(HttpStatus.NO_CONTENT);
        }
        Exam exam =  this.examService.updateExam(this.examMapper.dtoToModel(examDto));
        return new ResponseEntity<ExamDto>(this.examMapper.modelToDto(exam), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExamById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        examService.deleteExamById(id);
        return ResponseEntity.noContent().build();
    }
}
