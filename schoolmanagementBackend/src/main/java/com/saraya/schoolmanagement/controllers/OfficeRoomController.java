package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.OfficeRoomDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.OfficeRoomMapper;
import com.saraya.schoolmanagement.models.OfficeRoom;
import com.saraya.schoolmanagement.services.OfficeRoomService;
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
@RequestMapping(value = "/office-rooms")
public class OfficeRoomController {
    private final OfficeRoomService officeRoomService;

    private final OfficeRoomMapper officeRoomMapper;

    public OfficeRoomController(OfficeRoomService officeRoomService, OfficeRoomMapper officeRoomMapper) {
        this.officeRoomService = officeRoomService;
        this.officeRoomMapper = officeRoomMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createOfficeRoom(@RequestBody OfficeRoomDto officeRoomDto){

        OfficeRoom officeRoom =  officeRoomService.saveOfficeRoom(officeRoomMapper.dtoToModel(officeRoomDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(officeRoomMapper.modelToDto(officeRoom));
    }
    
    @GetMapping
    public ResponseEntity<List<OfficeRoomDto>> findAll(){
      List<OfficeRoom> officeRooms =  officeRoomService.findAllOfficeRooms();
      if (officeRooms.isEmpty()){
          return new ResponseEntity<List<OfficeRoomDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<OfficeRoomDto>>( officeRoomMapper.modelsToDtos(officeRooms), HttpStatus.OK);
    }

    /*@GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<OfficeRoom> officeRooms = new ArrayList<OfficeRoom>();
        Pageable pageable = PageRequest.of(page, size);
        Page<OfficeRoom> officeRoomPage = officeRoomService.findAllOfficeRooms(pageable);
        officeRooms = officeRoomPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("officeRooms",officeRoomMapper.modelsToDtos(officeRooms));
        response.put("currentPage",officeRoomPage.getNumber());
        response.put("totalItems",officeRoomPage.getTotalElements());
        response.put("totalPages",officeRoomPage.getTotalPages());
        if (officeRooms.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<OfficeRoomDto> findOfficeRoomById(@PathVariable Long id) throws ResourceNotFoundException {
        OfficeRoomDto officeRoomDto = officeRoomMapper.modelToDto(officeRoomService.findById(id));
        if (officeRoomDto == null || id ==null) {
            return new ResponseEntity<OfficeRoomDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<OfficeRoomDto>(officeRoomDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<OfficeRoomDto> updateOfficeRoomById(@RequestBody OfficeRoomDto officeRoomDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<OfficeRoomDto>(HttpStatus.NO_CONTENT);
        }
        OfficeRoom officeRoom =  this.officeRoomService.updateOfficeRoom(this.officeRoomMapper.dtoToModel(officeRoomDto));
        return new ResponseEntity<OfficeRoomDto>(this.officeRoomMapper.modelToDto(officeRoom), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOfficeRoomById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        officeRoomService.deleteOfficeRoomById(id);
        return ResponseEntity.noContent().build();
    }
}
