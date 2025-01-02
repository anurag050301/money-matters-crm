package org.moneymatters.crm.service;

import org.moneymatters.crm.dto.UserDto;
import org.moneymatters.crm.entity.Users;

import java.util.List;


public interface UserService {

    // Convert Users entity to UserDto
    public UserDto toDto(Users user) ;

    // Convert UserDto to Users entity
    public Users toEntity(UserDto userDto);

    public Users findByUsername(String username);

    public Users findByEmail(String email);

    //Get all users
    List<Users> getAllUsers();

    //Get user by ID
    UserDto getUser(long id);

    //Add a user
    UserDto addUser(UserDto userDto);

    //Update details of a User;
    UserDto updateUserDetails(UserDto userDto);

    //Delete User
    String deleteUser(long id);
}
