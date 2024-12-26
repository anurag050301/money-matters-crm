package org.moneymatters.crm.restController;

import jakarta.validation.Valid;
import org.moneymatters.crm.dto.UserDto;
import org.moneymatters.crm.entity.User;
import org.moneymatters.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private View error;


    //Get all the Users
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


    //Get Users on the basis of id;
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id) {
        UserDto responseUserDto = userService.getUser(id);
        return new ResponseEntity<>(responseUserDto, HttpStatus.OK);
    }


    //Add a new User Detail
    @PostMapping("/user/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, Map<String, String>> errors = new HashMap<>();
            List<FieldError> allErrors = bindingResult.getFieldErrors();
            Map<String, String> err = new HashMap<>();
            for(FieldError error: allErrors){
                err.put(error.getField(),error.getDefaultMessage());
            }
            errors.put("Errors",err);
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        List<String> availabilityError = new ArrayList<>();
        User availableUser = userService.findByUsername(userDto.getUsername());
        if(availableUser !=null){
           availabilityError.add("Username Already Exists");
            System.out.println("username");
        }
        availableUser = userService.findByEmail(userDto.getEmail());
        if(availableUser != null){
            availabilityError.add("Email Already Exists");
            System.out.println("email");
        }
        if(availableUser!=null){
            return new ResponseEntity<>(availabilityError, HttpStatus.BAD_REQUEST);
        }
        UserDto responseUserDto = userService.addUser(userDto);
        return new ResponseEntity<>(responseUserDto, HttpStatus.OK);
    }

    //Update User Detail
    @PutMapping("/user/update")
    public ResponseEntity<?> updateDetails(@RequestBody UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, Map<String, String>> errors = new HashMap<>();
            List<FieldError> allErrors = bindingResult.getFieldErrors();
            Map<String, String> err = new HashMap<>();
            for(FieldError error: allErrors){
                err.put(error.getField(),error.getDefaultMessage());
            }
            errors.put("Errors",err);
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        List<String> availabilityError = new ArrayList<>();
        User availableUser = userService.findByUsername(userDto.getUsername());
        if(availableUser !=null && availableUser.getId()!=userDto.getId()){
            availabilityError.add("Username Already Exists");
            System.out.println("username");
        }
        availableUser = userService.findByEmail(userDto.getEmail());
        if(availableUser != null && availableUser.getId()!=userDto.getId()){
            availabilityError.add("Email Already Exists");
            System.out.println("email");
        }
        if(availableUser!=null){
            return new ResponseEntity<>(availabilityError, HttpStatus.BAD_REQUEST);
        }

        UserDto responseUserDto = userService.updateUserDetails(userDto);
        return new ResponseEntity<>(responseUserDto, HttpStatus.OK);
    }

    //Delete User
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        String responseData = userService.deleteUser(id);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
