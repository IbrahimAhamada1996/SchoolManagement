package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Schedule;
import com.saraya.schoolmanagement.repositories.ScheduleRepository;
import com.saraya.schoolmanagement.services.ScheduleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImp implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImp(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Schedule findById(Long id) throws ResourceNotFoundException {
        Optional<Schedule> schedule = this.scheduleRepository.findScheduleById(id);
        if(!schedule.isPresent())
            throw new ResourceNotFoundException("Schedule not available");
        return schedule.get();
    }

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        schedule.setCreatedAt(LocalDateTime.now());
        return this.scheduleRepository.save(schedule);
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) {
        schedule.setUpdatedAt(LocalDateTime.now());
        return this.scheduleRepository.save(schedule);
    }

    @Override
    public void deleteScheduleById(Long id) throws ResourceNotFoundException {
        if (this.scheduleRepository.existsScheduleById(id))
            throw new ResourceNotFoundException("Impossible to delete this schedule");
        else
            this.scheduleRepository.deleteById(id);
    }

    @Override
    public List<Schedule> findAllSchedules() {
        return this.scheduleRepository.findAll();
    }

    @Override
    public Page<Schedule> findAllSchedules(Pageable pageable) {
        return this.scheduleRepository.findAll(pageable);
    }

    @Override
    public void deleteAllSchedules() {
        this.scheduleRepository.deleteAll();
    }

    @Override
    public boolean isScheduleExist(Schedule schedule) {
        return false;
    }
}
