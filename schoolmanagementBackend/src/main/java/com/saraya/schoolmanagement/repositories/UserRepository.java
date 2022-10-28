package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserById(Long id);
    List<User> findAll();
    Page<User> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsUserById(Long id);
}