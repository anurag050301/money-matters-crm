package org.moneymatters.crm.controller;

import org.moneymatters.crm.entity.User;
import org.moneymatters.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    //Get all the Users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }


    //Get Users on the basis of id;
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){
        return ResponseEntity.ok(userService.getUser(id));
    }


    //Add a new User Detail
    @PostMapping("/user/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }


    //Update User Detail
    @PutMapping("/user/update")
    public ResponseEntity<User> updateDetails(@RequestBody User user){
        return ResponseEntity.ok(userService.updateUserDetails(user));
    }


    //Delete User
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
