package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.ScheduleDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.ScheduleMapper;
import com.saraya.schoolmanagement.models.Schedule;
import com.saraya.schoolmanagement.services.ScheduleService;
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
@RequestMapping(value = "/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    private final ScheduleMapper scheduleMapper;

    public ScheduleController(ScheduleService scheduleService, ScheduleMapper scheduleMapper) {
        this.scheduleService = scheduleService;
        this.scheduleMapper = scheduleMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createSchedule(@RequestBody ScheduleDto scheduleDto){

        Schedule schedule =  scheduleService.saveSchedule(scheduleMapper.dtoToModel(scheduleDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleMapper.modelToDto(schedule));
    }
    
    @GetMapping
    public ResponseEntity<List<ScheduleDto>> findAll(){
      List<Schedule> schedules =  scheduleService.findAllSchedules();
      if (schedules.isEmpty()){
          return new ResponseEntity<List<ScheduleDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<ScheduleDto>>( scheduleMapper.modelsToDtos(schedules), HttpStatus.OK);
    }

   /* @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Schedule> schedules = new ArrayList<Schedule>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Schedule> schedulePage = scheduleService.findAllSchedules(pageable);
        schedules = schedulePage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("schedules",scheduleMapper.modelsToDtos(schedules));
        response.put("currentPage",schedulePage.getNumber());
        response.put("totalItems",schedulePage.getTotalElements());
        response.put("totalPages",schedulePage.getTotalPages());
        if (schedules.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDto> findScheduleById(@PathVariable Long id) throws ResourceNotFoundException {
        ScheduleDto scheduleDto = scheduleMapper.modelToDto(scheduleService.findById(id));
        if (scheduleDto == null || id ==null) {
            return new ResponseEntity<ScheduleDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ScheduleDto>(scheduleDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleDto> updateScheduleById(@RequestBody ScheduleDto scheduleDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<ScheduleDto>(HttpStatus.NO_CONTENT);
        }
        Schedule schedule =  this.scheduleService.updateSchedule(this.scheduleMapper.dtoToModel(scheduleDto));
        return new ResponseEntity<ScheduleDto>(this.scheduleMapper.modelToDto(schedule), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteScheduleById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        scheduleService.deleteScheduleById(id);
        return ResponseEntity.noContent().build();
    }
}
