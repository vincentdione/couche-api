package org.ovd.mapper;

import org.mapstruct.Mapper;
import org.ovd.dto.UserDto;
import org.ovd.entities.User;

@Mapper(componentModel = "cdi")
public interface IUserMapper {

    UserDto toUserDto(User user);
    User toUser(UserDto userDto);

}
