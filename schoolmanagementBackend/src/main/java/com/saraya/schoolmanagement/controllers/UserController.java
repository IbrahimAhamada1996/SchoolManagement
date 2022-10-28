package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.UserDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.UserMapper;
import com.saraya.schoolmanagement.models.User;
import com.saraya.schoolmanagement.services.UserService;
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
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createUser(@RequestBody UserDto userDto){
        User user =  userService.saveUser(userMapper.dtoToModel(userDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.modelToDto(user));
    }
    
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
      List<User> users =  userService.findAllUsers();
      if (users.isEmpty()){
          return new ResponseEntity<List<UserDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<UserDto>>( userMapper.modelsToDtos(users), HttpStatus.OK);
    }

   /* @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<User> users = new ArrayList<User>();
        Pageable pageable = PageRequest.of(page, size);
        Page<User> userPage = userService.findAllUsers(pageable);
        users = userPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("users",userMapper.modelsToDtos(users));
        response.put("currentPage",userPage.getNumber());
        response.put("totalItems",userPage.getTotalElements());
        response.put("totalPages",userPage.getTotalPages());
        if (users.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long id) throws ResourceNotFoundException {
        UserDto userDto = userMapper.modelToDto(userService.findById(id));
        if (userDto == null || id ==null) {
            return new ResponseEntity<UserDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUserById(@RequestBody UserDto userDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<UserDto>(HttpStatus.NO_CONTENT);
        }
        User user =  this.userService.updateUser(this.userMapper.dtoToModel(userDto));
        return new ResponseEntity<UserDto>(this.userMapper.modelToDto(user), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
