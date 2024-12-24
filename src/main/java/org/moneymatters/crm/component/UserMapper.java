package org.moneymatters.crm.component;

import org.modelmapper.ModelMapper;
import org.moneymatters.crm.dto.UserDto;
import org.moneymatters.crm.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper{

    private final ModelMapper modelMapper;

    public UserMapper() {
        this.modelMapper = new ModelMapper();
    }

    // Convert User entity to UserDto
    public UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    // Convert UserDto to User entity
    public User toEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
