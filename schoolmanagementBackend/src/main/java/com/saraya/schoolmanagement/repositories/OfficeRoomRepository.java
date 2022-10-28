package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.OfficeRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfficeRoomRepository extends CrudRepository<OfficeRoom,Long> {
    Optional<OfficeRoom> findOfficeRoomById(Long id);
    List<OfficeRoom> findAll();
    Page<OfficeRoom> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsOfficeRoomById(Long id);
}
