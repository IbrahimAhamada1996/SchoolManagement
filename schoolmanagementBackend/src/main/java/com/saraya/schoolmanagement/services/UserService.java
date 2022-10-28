package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User findById(Long id) throws ResourceNotFoundException;

    User saveUser(User user);

    User updateUser(User user);

    void deleteUserById(Long id) throws ResourceNotFoundException;

    List<User> findAllUsers();
    Page<User> findAllUsers(Pageable pageable);

    void deleteAllUsers();

    boolean isUserExist(User user);
}
