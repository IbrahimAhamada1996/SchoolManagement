package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.SessionDto;
import com.saraya.schoolmanagement.models.Session;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SessionMapper {

    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

    SessionDto modelToDto(Session session);
    List<SessionDto> modelsToDtos(List<Session> sessions);

    Session dtoToModel(SessionDto sessionDto);
}
