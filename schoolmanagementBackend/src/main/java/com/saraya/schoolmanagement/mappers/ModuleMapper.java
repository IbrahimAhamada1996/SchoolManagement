package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.ModuleDto;
import com.saraya.schoolmanagement.models.Module;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModuleMapper {

    ModuleMapper INSTANCE = Mappers.getMapper(ModuleMapper.class);

    ModuleDto modelToDto(Module module);
    List<ModuleDto> modelsToDtos(List<Module> modules);

    Module dtoToModel(ModuleDto moduleDto);
}
