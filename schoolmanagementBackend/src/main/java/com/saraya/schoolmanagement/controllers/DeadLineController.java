package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.DeadLineDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.DeadLineMapper;
import com.saraya.schoolmanagement.models.DeadLine;
import com.saraya.schoolmanagement.services.DeadLineService;
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
@RequestMapping(value = "/deadlines")
public class DeadLineController {

    private final DeadLineService deadLineService;

    private final DeadLineMapper deadLineMapper;

    public DeadLineController(DeadLineService deadLineService, DeadLineMapper deadLineMapper) {
        this.deadLineService = deadLineService;
        this.deadLineMapper = deadLineMapper;
    }


    @PostMapping
    public ResponseEntity<?>
    createDeadLine(@RequestBody DeadLineDto deadLineDto){

        DeadLine deadLine =  deadLineService.saveDeadLine(deadLineMapper.dtoToModel(deadLineDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(deadLineMapper.modelToDto(deadLine));
    }
    
    @GetMapping
    public ResponseEntity<List<DeadLineDto>> findAll(){
      List<DeadLine> deadLines =  deadLineService.findAllDeadLines();
      if (deadLines.isEmpty()){
          return new ResponseEntity<List<DeadLineDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<DeadLineDto>>( deadLineMapper.modelsToDtos(deadLines), HttpStatus.OK);
    }

    /*@GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<DeadLine> deadLines = new ArrayList<DeadLine>();
        Pageable pageable = PageRequest.of(page, size);
        Page<DeadLine> deadLinePage = deadLineService.findAllDeadLines(pageable);
        deadLines = deadLinePage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("deadLines",deadLineMapper.modelsToDtos(deadLines));
        response.put("currentPage",deadLinePage.getNumber());
        response.put("totalItems",deadLinePage.getTotalElements());
        response.put("totalPages",deadLinePage.getTotalPages());
        if (deadLines.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<DeadLineDto> findDeadLineById(@PathVariable Long id) throws ResourceNotFoundException {
        DeadLineDto deadLineDto = deadLineMapper.modelToDto(deadLineService.findById(id));
        if (deadLineDto == null || id ==null) {
            return new ResponseEntity<DeadLineDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<DeadLineDto>(deadLineDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<DeadLineDto> updateDeadLineById(@RequestBody DeadLineDto deadLineDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<DeadLineDto>(HttpStatus.NO_CONTENT);
        }
        DeadLine deadLine =  this.deadLineService.updateDeadLine(this.deadLineMapper.dtoToModel(deadLineDto));
        return new ResponseEntity<DeadLineDto>(this.deadLineMapper.modelToDto(deadLine), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDeadLineById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        deadLineService.deleteDeadLineById(id);
        return ResponseEntity.noContent().build();
    }
}
