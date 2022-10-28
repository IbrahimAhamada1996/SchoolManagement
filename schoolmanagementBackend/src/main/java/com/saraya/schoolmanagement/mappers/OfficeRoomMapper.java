package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.OfficeRoomDto;
import com.saraya.schoolmanagement.models.OfficeRoom;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OfficeRoomMapper {

    OfficeRoomMapper INSTANCE = Mappers.getMapper(OfficeRoomMapper.class);

    OfficeRoomDto modelToDto(OfficeRoom officeRoom);
    List<OfficeRoomDto> modelsToDtos(List<OfficeRoom> officeRooms);

    OfficeRoom dtoToModel(OfficeRoomDto officeRoomDto);
}
