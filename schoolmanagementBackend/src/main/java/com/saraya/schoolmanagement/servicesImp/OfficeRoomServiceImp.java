package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.OfficeRoom;
import com.saraya.schoolmanagement.repositories.OfficeRoomRepository;
import com.saraya.schoolmanagement.services.OfficeRoomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeRoomServiceImp implements OfficeRoomService {
    private final OfficeRoomRepository officeRoomRepository;

    public OfficeRoomServiceImp(OfficeRoomRepository officeRoomRepository) {
        this.officeRoomRepository = officeRoomRepository;
    }

    @Override
    public OfficeRoom findById(Long id) throws ResourceNotFoundException {
        Optional<OfficeRoom> officeRoom = this.officeRoomRepository.findOfficeRoomById(id);
        if (!officeRoom.isPresent())
            throw new ResourceNotFoundException("OfficeRoom not available");
        return officeRoom.get();
    }

    @Override
    public OfficeRoom saveOfficeRoom(OfficeRoom officeRoom) {
        return this.officeRoomRepository.save(officeRoom);
    }

    @Override
    public OfficeRoom updateOfficeRoom(OfficeRoom officeRoom) {
        return this.officeRoomRepository.save(officeRoom);
    }

    @Override
    public void deleteOfficeRoomById(Long id) throws ResourceNotFoundException {
        if (!this.officeRoomRepository.existsOfficeRoomById(id))
            throw new ResourceNotFoundException("Impossible to delete OfficeRoom");
        else
            this.officeRoomRepository.deleteById(id);
    }

    @Override
    public List<OfficeRoom> findAllOfficeRooms() {
        return this.officeRoomRepository.findAll();
    }

    @Override
    public Page<OfficeRoom> findAllOfficeRooms(Pageable pageable) {
        return this.officeRoomRepository.findAll(pageable);
    }

    @Override
    public void deleteAllOfficeRooms() {
        this.officeRoomRepository.deleteAll();
    }

    @Override
    public boolean isOfficeRoomExist(OfficeRoom officeRoom) {
        return false;
    }
}
