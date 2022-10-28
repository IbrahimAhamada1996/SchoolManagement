package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Unity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UnityRepository extends CrudRepository<Unity,Long> {
    Optional<Unity> findUnityById(Long id);
    List<Unity> findAll();
    Page<Unity> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsUnityById(Long id);
}
