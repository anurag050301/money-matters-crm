package org.moneymatters.crm.service;

import org.moneymatters.crm.dto.UserDto;
import org.moneymatters.crm.entity.User;

import java.util.List;


public interface UserService {

    // Convert User entity to UserDto
    public UserDto toDto(User user) ;

    // Convert UserDto to User entity
    public User toEntity(UserDto userDto);

    //Get all users
    List<User> getAllUsers();

    //Get user by ID
    UserDto getUser(long id);

    //Add a user
    UserDto addUser(UserDto userDto);

    //Update details of a User;
    UserDto updateUserDetails(UserDto userDto);

    //Delete User
    String deleteUser(long id);
}
