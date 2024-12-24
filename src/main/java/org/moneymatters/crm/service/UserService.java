package org.moneymatters.crm.service;

import org.modelmapper.ModelMapper;
import org.moneymatters.crm.component.UserMapper;
import org.moneymatters.crm.dto.UserDto;
import org.moneymatters.crm.entity.User;

import java.util.List;


public interface UserService {

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
