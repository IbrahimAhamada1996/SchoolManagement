package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.UnityDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.UnityMapper;
import com.saraya.schoolmanagement.models.Unity;
import com.saraya.schoolmanagement.services.UnityService;
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
@RequestMapping(value = "/unities")
public class UnityController {

    private final UnityService unityService;

    private final UnityMapper unityMapper;

    public UnityController(UnityService unityService, UnityMapper unityMapper) {
        this.unityService = unityService;
        this.unityMapper = unityMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createUnity(@RequestBody UnityDto unityDto){
        Unity unity =  unityService.saveUnity(unityMapper.dtoToModel(unityDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(unityMapper.modelToDto(unity));
    }

    @GetMapping
    public ResponseEntity<List<UnityDto>> findAll(){
      List<Unity> unitys =  unityService.findAllUnitys();
      if (unitys.isEmpty()){
          return new ResponseEntity<List<UnityDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<UnityDto>>( unityMapper.modelsToDtos(unitys), HttpStatus.OK);
    }
/*
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Unity> unitys = new ArrayList<Unity>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Unity> unityPage = unityService.findAllUnitys(pageable);
        unitys = unityPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("unitys",unityMapper.modelsToDtos(unitys));
        response.put("currentPage",unityPage.getNumber());
        response.put("totalItems",unityPage.getTotalElements());
        response.put("totalPages",unityPage.getTotalPages());
        if (unitys.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<UnityDto> findUnityById(@PathVariable Long id) throws ResourceNotFoundException {
        UnityDto unityDto = unityMapper.modelToDto(unityService.findById(id));
        if (unityDto == null || id ==null) {
            return new ResponseEntity<UnityDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<UnityDto>(unityDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<UnityDto> updateUnityById(@RequestBody UnityDto unityDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<UnityDto>(HttpStatus.NO_CONTENT);
        }
        Unity unity =  this.unityService.updateUnity(this.unityMapper.dtoToModel(unityDto));
        return new ResponseEntity<UnityDto>(this.unityMapper.modelToDto(unity), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUnityById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        unityService.deleteUnityById(id);
        return ResponseEntity.noContent().build();
    }
}
