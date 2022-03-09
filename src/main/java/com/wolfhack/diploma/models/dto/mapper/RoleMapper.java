package com.wolfhack.diploma.models.dto.mapper;

import com.wolfhack.diploma.models.dto.RoleDto;
import com.wolfhack.diploma.models.dto.UserDto;
import com.wolfhack.diploma.models.users.Role;
import com.wolfhack.diploma.models.users.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

     RoleDto toDto(Role user);

     Role toUser(RoleDto dto);

     List<RoleDto> toDtos(List<Role> usesrs);

}
