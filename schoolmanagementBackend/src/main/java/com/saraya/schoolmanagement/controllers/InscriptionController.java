package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.InscriptionDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.InscriptionMapper;
import com.saraya.schoolmanagement.models.Inscription;
import com.saraya.schoolmanagement.services.InscriptionService;
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
@RequestMapping(value = "/inscriptions")
public class InscriptionController {

    private final InscriptionService inscriptionService;

    private final InscriptionMapper inscriptionMapper;

    public InscriptionController(InscriptionService inscriptionService, InscriptionMapper inscriptionMapper) {
        this.inscriptionService = inscriptionService;
        this.inscriptionMapper = inscriptionMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createInscription(@RequestBody InscriptionDto inscriptionDto){

        Inscription inscription =  inscriptionService.saveInscription(inscriptionMapper.dtoToModel(inscriptionDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(inscriptionMapper.modelToDto(inscription));
    }
    
    @GetMapping
    public ResponseEntity<List<InscriptionDto>> findAll(){
      List<Inscription> inscriptions =  inscriptionService.findAllInscriptions();
      if (inscriptions.isEmpty()){
          return new ResponseEntity<List<InscriptionDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<InscriptionDto>>( inscriptionMapper.modelsToDtos(inscriptions), HttpStatus.OK);
    }

   /* @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Inscription> inscriptions = new ArrayList<Inscription>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Inscription> inscriptionPage = inscriptionService.findAllInscriptions(pageable);
        inscriptions = inscriptionPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("inscriptions",inscriptionMapper.modelsToDtos(inscriptions));
        response.put("currentPage",inscriptionPage.getNumber());
        response.put("totalItems",inscriptionPage.getTotalElements());
        response.put("totalPages",inscriptionPage.getTotalPages());
        if (inscriptions.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<InscriptionDto> findInscriptionById(@PathVariable Long id) throws ResourceNotFoundException {
        InscriptionDto inscriptionDto = inscriptionMapper.modelToDto(inscriptionService.findById(id));
        if (inscriptionDto == null || id ==null) {
            return new ResponseEntity<InscriptionDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<InscriptionDto>(inscriptionDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<InscriptionDto> updateInscriptionById(@RequestBody InscriptionDto inscriptionDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<InscriptionDto>(HttpStatus.NO_CONTENT);
        }
        Inscription inscription =  this.inscriptionService.updateInscription(this.inscriptionMapper.dtoToModel(inscriptionDto));
        return new ResponseEntity<InscriptionDto>(this.inscriptionMapper.modelToDto(inscription), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInscriptionById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        inscriptionService.deleteInscriptionById(id);
        return ResponseEntity.noContent().build();
    }
}
