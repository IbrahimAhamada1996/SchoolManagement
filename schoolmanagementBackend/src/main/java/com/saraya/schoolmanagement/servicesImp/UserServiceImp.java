package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.User;
import com.saraya.schoolmanagement.repositories.RoleRepository;
import com.saraya.schoolmanagement.repositories.UserRepository;
import com.saraya.schoolmanagement.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) throws ResourceNotFoundException {
        Optional<User> user = this.userRepository.findUserById(id);
        if (!user.isPresent())
            throw new ResourceNotFoundException("User not available");
        return user.get();
    }

    @Override
    public User saveUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        user.setUpdatedAt(LocalDateTime.now());
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) throws ResourceNotFoundException {
        if (!this.userRepository.existsUserById(id))
            throw new ResourceNotFoundException("Impossible to delete this User");
        else
            this.userRepository.deleteById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Page<User> findAllUsers(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public void deleteAllUsers() {
     this.userRepository.deleteAll();
    }

    @Override
    public boolean isUserExist(User user) {
        return false;
    }
}
