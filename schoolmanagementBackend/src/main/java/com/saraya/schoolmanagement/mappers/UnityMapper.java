package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.UnityDto;
import com.saraya.schoolmanagement.models.Unity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UnityMapper {

    UnityMapper INSTANCE = Mappers.getMapper(UnityMapper.class);

    UnityDto modelToDto(Unity unity);
    List<UnityDto> modelsToDtos(List<Unity> unities);

    Unity dtoToModel(UnityDto unityDto);
}
