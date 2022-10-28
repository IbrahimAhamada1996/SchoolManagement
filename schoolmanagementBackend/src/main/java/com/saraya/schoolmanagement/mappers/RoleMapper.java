package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.RoleDto;
import com.saraya.schoolmanagement.models.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDto modelToDto(Role role);
    List<RoleDto> modelsToDtos(List<Role> roles);

    Role dtoToModel(RoleDto roleDto);
}
