package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.CourseDto;
import com.saraya.schoolmanagement.models.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDto modelToDto(Course course);
    List<CourseDto> modelsToDtos(List<Course> courses);

    Course dtoToModel(CourseDto courseDto);

}
