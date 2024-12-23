package org.moneymatters.crm.service;

import org.moneymatters.crm.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    //Get all users
    List<User> getAllUsers();

    //Get user by ID
    User getUser(long id);

    //Add a user
    String addUser(User newUser);

    //Update details of a User;
    User updateUserDetails(User newDetails);

    //Delete User
    String deleteUser(long id);

}
