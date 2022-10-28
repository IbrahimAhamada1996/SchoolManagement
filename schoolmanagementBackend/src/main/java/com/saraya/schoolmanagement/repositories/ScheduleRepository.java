package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule,Long> {
    Optional<Schedule> findScheduleById(Long id);
    List<Schedule> findAll();
    Page<Schedule> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsScheduleById(Long id);
}
