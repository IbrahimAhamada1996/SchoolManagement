package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.ScheduleDto;
import com.saraya.schoolmanagement.models.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    ScheduleDto modelToDto(Schedule schedule);
    List<ScheduleDto> modelsToDtos(List<Schedule> schedules);

    Schedule dtoToModel(ScheduleDto scheduleDto);
}
