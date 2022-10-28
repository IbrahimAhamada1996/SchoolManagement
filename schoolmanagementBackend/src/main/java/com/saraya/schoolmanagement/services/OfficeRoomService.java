package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.OfficeRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OfficeRoomService {
    OfficeRoom findById(Long id) throws ResourceNotFoundException;

    OfficeRoom saveOfficeRoom(OfficeRoom officeRoom);

    OfficeRoom updateOfficeRoom(OfficeRoom officeRoom);

    void deleteOfficeRoomById(Long id) throws ResourceNotFoundException;

    List<OfficeRoom> findAllOfficeRooms();
    Page<OfficeRoom> findAllOfficeRooms(Pageable pageable);

    void deleteAllOfficeRooms();

    boolean isOfficeRoomExist(OfficeRoom officeRoom);
}
