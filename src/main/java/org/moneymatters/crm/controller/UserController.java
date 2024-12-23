package org.moneymatters.crm.controller;

import org.moneymatters.crm.entity.User;
import org.moneymatters.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    //Get all the Users
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    //Get Users on the basis of id;
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id){
        return userService.getUser(id);
    }


    //Add a new User Detail
    @PostMapping("/user/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }


    //Update User Detail
    @PutMapping("/user/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User updateDetails(@RequestBody User user){
        return userService.updateUserDetails(user);
    }


    //Delete User
    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }
}
