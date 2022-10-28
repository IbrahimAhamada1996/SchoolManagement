package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.RoleDto;
import com.saraya.schoolmanagement.enums.RoleName;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.RoleMapper;
import com.saraya.schoolmanagement.models.Role;
import com.saraya.schoolmanagement.services.RoleService;
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
@RequestMapping(value = "/roles")
public class RoleController {
    private final RoleService roleService;

    private final RoleMapper roleMapper;

    public RoleController(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createRole(@RequestBody RoleDto roleDto){
        Role role =  roleService.saveRole(roleMapper.dtoToModel(roleDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(roleMapper.modelToDto(role));
    }
    
    @GetMapping
    public ResponseEntity<List<RoleDto>> findAll(){
      List<Role> roles =  roleService.findAllRoles();
      if (roles.isEmpty()){
          return new ResponseEntity<List<RoleDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<RoleDto>>( roleMapper.modelsToDtos(roles), HttpStatus.OK);
    }
/*
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Role> roles = new ArrayList<Role>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Role> rolePage = roleService.findAllRoles(pageable);
        roles = rolePage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("roles",roleMapper.modelsToDtos(roles));
        response.put("currentPage",rolePage.getNumber());
        response.put("totalItems",rolePage.getTotalElements());
        response.put("totalPages",rolePage.getTotalPages());
        if (roles.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{roleName}")
    public ResponseEntity<RoleDto> findRoleBySlug(@PathVariable String roleName) throws ResourceNotFoundException {
        RoleDto roleDto = roleMapper.modelToDto(roleService.findByRoleName(RoleName.valueOf(roleName)));
        if (roleDto == null || roleName ==null) {
            return new ResponseEntity<RoleDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<RoleDto>(roleDto, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> updateRoleById(@RequestBody RoleDto roleDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<RoleDto>(HttpStatus.NO_CONTENT);
        }
        Role role =  this.roleService.updateRole(this.roleMapper.dtoToModel(roleDto));
        return new ResponseEntity<RoleDto>(this.roleMapper.modelToDto(role), HttpStatus.OK);

    }

    @DeleteMapping("/{roleName}")
    public ResponseEntity<?> deleteRoleBySlug(@PathVariable String roleName) throws ResourceNotFoundException {
        if (roleName == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        roleService.deleteRoleByRoleName(RoleName.valueOf(roleName));
        return ResponseEntity.noContent().build();
    }
}
