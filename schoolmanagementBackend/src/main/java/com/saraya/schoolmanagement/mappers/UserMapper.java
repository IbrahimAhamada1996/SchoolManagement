package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.UserDto;
import com.saraya.schoolmanagement.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto modelToDto(User user);
    List<UserDto> modelsToDtos(List<User> users);

    User dtoToModel(UserDto userDto);
}
