package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParentRepository extends CrudRepository<Parent,Long> {
    Optional<Parent> findParentById(Long id);
    List<Parent> findAll();
    Page<Parent> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsParentById(Long id);
}
