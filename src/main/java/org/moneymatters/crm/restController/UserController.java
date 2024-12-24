package org.moneymatters.crm.restController;

import org.moneymatters.crm.model.User;
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
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    //Get Users on the basis of id;
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }


    //Add a new User Detail
    @PostMapping("/user/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }


    //Update User Detail
    @PutMapping("/user/update")
    public ResponseEntity<User> updateDetails(@RequestBody User user){
        return new ResponseEntity<>(userService.updateUserDetails(user), HttpStatus.OK);
    }


    //Delete User
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
}
