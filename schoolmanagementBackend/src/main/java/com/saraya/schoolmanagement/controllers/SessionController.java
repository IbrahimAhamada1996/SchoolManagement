package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.SessionDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.SessionMapper;
import com.saraya.schoolmanagement.models.Session;
import com.saraya.schoolmanagement.services.SessionService;
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
@RequestMapping(value = "/sessions")
public class SessionController {

    private final SessionService sessionService;

    private final SessionMapper sessionMapper;

    public SessionController(SessionService sessionService, SessionMapper sessionMapper) {
        this.sessionService = sessionService;
        this.sessionMapper = sessionMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createSession(@RequestBody SessionDto sessionDto){
        Session session =  sessionService.saveSession(sessionMapper.dtoToModel(sessionDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(sessionMapper.modelToDto(session));
    }

    @GetMapping
    public ResponseEntity<List<SessionDto>> findAll(){
      List<Session> sessions =  sessionService.findAllSessions();
      if (sessions.isEmpty()){
          return new ResponseEntity<List<SessionDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<SessionDto>>( sessionMapper.modelsToDtos(sessions), HttpStatus.OK);
    }

   /* @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Session> sessions = new ArrayList<Session>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Session> sessionPage = sessionService.findAllSessions(pageable);
        sessions = sessionPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("sessions",sessionMapper.modelsToDtos(sessions));
        response.put("currentPage",sessionPage.getNumber());
        response.put("totalItems",sessionPage.getTotalElements());
        response.put("totalPages",sessionPage.getTotalPages());
        if (sessions.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<SessionDto> findSessionById(@PathVariable Long id) throws ResourceNotFoundException {
        SessionDto sessionDto = sessionMapper.modelToDto(sessionService.findById(id));
        if (sessionDto == null || id ==null) {
            return new ResponseEntity<SessionDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<SessionDto>(sessionDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<SessionDto> updateSessionById(@RequestBody SessionDto sessionDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<SessionDto>(HttpStatus.NO_CONTENT);
        }
        Session session =  this.sessionService.updateSession(this.sessionMapper.dtoToModel(sessionDto));
        return new ResponseEntity<SessionDto>(this.sessionMapper.modelToDto(session), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSessionById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        sessionService.deleteSessionById(id);
        return ResponseEntity.noContent().build();
    }
}
