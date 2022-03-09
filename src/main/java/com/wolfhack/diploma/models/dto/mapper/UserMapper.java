package com.wolfhack.diploma.models.dto.mapper;

import com.wolfhack.diploma.models.dto.UserDto;
import com.wolfhack.diploma.models.users.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

     UserDto toDto(User user);

     User toUser(UserDto dto);

     List<UserDto> toDtos(List<User> usesrs);

}
