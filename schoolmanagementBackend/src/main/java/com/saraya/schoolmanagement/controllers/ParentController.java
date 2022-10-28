package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.ParentDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.ParentMapper;
import com.saraya.schoolmanagement.models.Parent;
import com.saraya.schoolmanagement.services.ParentService;
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
@RequestMapping(value = "/parents")
public class ParentController {

    private final ParentService parentService;

    private final ParentMapper parentMapper;

    public ParentController(ParentService parentService, ParentMapper parentMapper) {
        this.parentService = parentService;
        this.parentMapper = parentMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createParent(@RequestBody ParentDto parentDto){
        Parent parent =  parentService.saveParent(parentMapper.dtoToModel(parentDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(parentMapper.modelToDto(parent));
    }
    
    @GetMapping
    public ResponseEntity<List<ParentDto>> findAll(){
      List<Parent> parents =  parentService.findAllParents();
      if (parents.isEmpty()){
          return new ResponseEntity<List<ParentDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<ParentDto>>( parentMapper.modelsToDtos(parents), HttpStatus.OK);
    }

   /* @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Parent> parents = new ArrayList<Parent>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Parent> parentPage = parentService.findAllParents(pageable);
        parents = parentPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("parents",parentMapper.modelsToDtos(parents));
        response.put("currentPage",parentPage.getNumber());
        response.put("totalItems",parentPage.getTotalElements());
        response.put("totalPages",parentPage.getTotalPages());
        if (parents.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<ParentDto> findParentById(@PathVariable Long id) throws ResourceNotFoundException {
        ParentDto parentDto = parentMapper.modelToDto(parentService.findById(id));
        if (parentDto == null || id ==null) {
            return new ResponseEntity<ParentDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ParentDto>(parentDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<ParentDto> updateParentById(@RequestBody ParentDto parentDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<ParentDto>(HttpStatus.NO_CONTENT);
        }
        Parent parent =  this.parentService.updateParent(this.parentMapper.dtoToModel(parentDto));
        return new ResponseEntity<ParentDto>(this.parentMapper.modelToDto(parent), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParentById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        parentService.deleteParentById(id);
        return ResponseEntity.noContent().build();
    }
}
