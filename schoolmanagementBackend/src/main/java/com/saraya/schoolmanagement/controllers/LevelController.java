package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.LevelDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.LevelMapper;
import com.saraya.schoolmanagement.models.Level;
import com.saraya.schoolmanagement.services.LevelService;
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
@RequestMapping(value = "/levels")
public class LevelController {

    private final LevelService levelService;

    private final LevelMapper levelMapper;

    public LevelController(LevelService levelService, LevelMapper levelMapper) {
        this.levelService = levelService;
        this.levelMapper = levelMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createLevel(@RequestBody LevelDto levelDto){
        Level level =  levelService.saveLevel(levelMapper.dtoToModel(levelDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(levelMapper.modelToDto(level));
    }
    
    @GetMapping
    public ResponseEntity<List<LevelDto>> findAll(){
      List<Level> levels =  levelService.findAllLevels();
      if (levels.isEmpty()){
          return new ResponseEntity<List<LevelDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<LevelDto>>( levelMapper.modelsToDtos(levels), HttpStatus.OK);
    }

    /*@GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Level> levels = new ArrayList<Level>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Level> levelPage = levelService.findAllLevels(pageable);
        levels = levelPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("levels",levelMapper.modelsToDtos(levels));
        response.put("currentPage",levelPage.getNumber());
        response.put("totalItems",levelPage.getTotalElements());
        response.put("totalPages",levelPage.getTotalPages());
        if (levels.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }
*/
    @GetMapping("/{id}")
    public ResponseEntity<LevelDto> findLevelById(@PathVariable Long id) throws ResourceNotFoundException {
        LevelDto levelDto = levelMapper.modelToDto(levelService.findById(id));
        if (levelDto == null || id ==null) {
            return new ResponseEntity<LevelDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<LevelDto>(levelDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<LevelDto> updateLevelById(@RequestBody LevelDto levelDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<LevelDto>(HttpStatus.NO_CONTENT);
        }
        Level level =  this.levelService.updateLevel(this.levelMapper.dtoToModel(levelDto));
        return new ResponseEntity<LevelDto>(this.levelMapper.modelToDto(level), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLevelById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        levelService.deleteLevelById(id);
        return ResponseEntity.noContent().build();
    }
}
