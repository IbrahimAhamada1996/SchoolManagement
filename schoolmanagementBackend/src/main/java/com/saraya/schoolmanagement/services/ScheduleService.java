package com.saraya.schoolmanagement.services;


import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ScheduleService {
    Schedule findById(Long id) throws ResourceNotFoundException;

    Schedule saveSchedule(Schedule schedule);

    Schedule updateSchedule(Schedule schedule);

    void deleteScheduleById(Long id) throws ResourceNotFoundException;

    List<Schedule> findAllSchedules();
    Page<Schedule> findAllSchedules(Pageable pageable);
    void deleteAllSchedules();

    boolean isScheduleExist(Schedule schedule);
}
