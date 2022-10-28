package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.DeadLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeadLineRepository extends CrudRepository<DeadLine,Long> {

    Optional<DeadLine> findDeadLineById(Long id);
    List<DeadLine> findAll();
    Page<DeadLine> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsDeadLineById(Long id);
}
