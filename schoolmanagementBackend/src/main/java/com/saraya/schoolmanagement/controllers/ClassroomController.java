package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.ClassroomDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.ClassroomMapper;
import com.saraya.schoolmanagement.models.Classroom;
import com.saraya.schoolmanagement.services.ClassroomService;
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
@RequestMapping(value = "/classrooms")
public class ClassroomController {

    private final ClassroomService classroomService;

    private final ClassroomMapper classroomMapper;

    public ClassroomController(ClassroomService classroomService, ClassroomMapper classroomMapper) {
        this.classroomService = classroomService;
        this.classroomMapper = classroomMapper;
    }


    @PostMapping
    public ResponseEntity<?>
    createClassroom(@RequestBody ClassroomDto classroomDto){

        Classroom classroom =  classroomService.saveClassroom(classroomMapper.dtoToModel(classroomDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(classroomMapper.modelToDto(classroom));
    }
    
    @GetMapping
    public ResponseEntity<List<ClassroomDto>> findAll(){
      List<Classroom> classrooms =  classroomService.findAllClassrooms();
      if (classrooms.isEmpty()){
          return new ResponseEntity<List<ClassroomDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<ClassroomDto>>( classroomMapper.modelsToDtos(classrooms), HttpStatus.OK);
    }

   /* @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Classroom> classrooms = new ArrayList<Classroom>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Classroom> classroomPage = classroomService.findAllClassrooms(pageable);
        classrooms = classroomPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("classrooms",classroomMapper.modelsToDtos(classrooms));
        response.put("currentPage",classroomPage.getNumber());
        response.put("totalItems",classroomPage.getTotalElements());
        response.put("totalPages",classroomPage.getTotalPages());
        if (classrooms.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDto> findClassroomById(@PathVariable Long id) throws ResourceNotFoundException {
        ClassroomDto classroomDto = classroomMapper.modelToDto(classroomService.findById(id));
        if (classroomDto == null || id ==null) {
            return new ResponseEntity<ClassroomDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ClassroomDto>(classroomDto, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassroomDto> updateClassroomById(@RequestBody ClassroomDto classroomDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<ClassroomDto>(HttpStatus.NO_CONTENT);
        }
        Classroom classroom =  this.classroomService.updateClassroom(this.classroomMapper.dtoToModel(classroomDto));
        return new ResponseEntity<ClassroomDto>(this.classroomMapper.modelToDto(classroom), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClassroomById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        classroomService.deleteClassroomById(id);
        return ResponseEntity.noContent().build();
    }
}
