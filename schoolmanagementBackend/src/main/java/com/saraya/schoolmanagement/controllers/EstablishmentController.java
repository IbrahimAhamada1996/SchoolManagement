package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.EstablishmentDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.EstablishmentMapper;
import com.saraya.schoolmanagement.models.Establishment;
import com.saraya.schoolmanagement.services.EstablishmentService;
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
@RequestMapping(value = "/establishments")
public class EstablishmentController {

    private final EstablishmentService establishmentService;

    private final EstablishmentMapper establishmentMapper;

    public EstablishmentController(EstablishmentService establishmentService, EstablishmentMapper establishmentMapper) {
        this.establishmentService = establishmentService;
        this.establishmentMapper = establishmentMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createEstablishment(@RequestBody EstablishmentDto establishmentDto){

        Establishment establishment =  establishmentService.saveEstablishment(establishmentMapper.dtoToModel(establishmentDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(establishmentMapper.modelToDto(establishment));
    }
    
    @GetMapping
    public ResponseEntity<List<EstablishmentDto>> findAll(){
      List<Establishment> establishments =  establishmentService.findAllEstablishments();
      if (establishments.isEmpty()){
          return new ResponseEntity<List<EstablishmentDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<EstablishmentDto>>( establishmentMapper.modelsToDtos(establishments), HttpStatus.OK);
    }

    /*@GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Establishment> establishments = new ArrayList<Establishment>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Establishment> establishmentPage = establishmentService.findAllEstablishments(pageable);
        establishments = establishmentPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("establishments",establishmentMapper.modelsToDtos(establishments));
        response.put("currentPage",establishmentPage.getNumber());
        response.put("totalItems",establishmentPage.getTotalElements());
        response.put("totalPages",establishmentPage.getTotalPages());
        if (establishments.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<EstablishmentDto> findEstablishmentById(@PathVariable Long id) throws ResourceNotFoundException {
        EstablishmentDto establishmentDto = establishmentMapper.modelToDto(establishmentService.findById(id));
        if (establishmentDto == null || id ==null) {
            return new ResponseEntity<EstablishmentDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<EstablishmentDto>(establishmentDto, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<EstablishmentDto> updateEstablishmentById(@RequestBody EstablishmentDto establishmentDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<EstablishmentDto>(HttpStatus.NO_CONTENT);
        }
        Establishment establishment =  this.establishmentService.updateEstablishment(this.establishmentMapper.dtoToModel(establishmentDto));
        return new ResponseEntity<EstablishmentDto>(this.establishmentMapper.modelToDto(establishment), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEstablishmentById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        establishmentService.deleteEstablishmentById(id);
        return ResponseEntity.noContent().build();
    }
}
