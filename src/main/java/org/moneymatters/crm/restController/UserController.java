package org.moneymatters.crm.restController;

import jakarta.validation.Valid;
import org.moneymatters.crm.dto.ErrorDetails;
import org.moneymatters.crm.dto.UserDto;
import org.moneymatters.crm.entity.Users;
import org.moneymatters.crm.exception.UserAlreadyExistsException;
import org.moneymatters.crm.exception.ValidationException;
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

    //Get all the Users
    @GetMapping("/user/all")
    public ResponseEntity<?> getAllUsers() {
        List<Users> allUsers = userService.getAllUsers();
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
        StringBuilder msg = new StringBuilder();
        if (bindingResult.hasErrors()) {
            List<FieldError> allErrors = bindingResult.getFieldErrors();
            for (FieldError error : allErrors) {
                msg.append(error.getDefaultMessage());
                msg.append("; ");
            }
        }
        Users availableUser = userService.findByUsername(userDto.getUsername());
        if (availableUser != null) {
            msg.append("Username Already Exists. ");
        }
        availableUser = userService.findByEmail(userDto.getEmail());
        if (availableUser != null) {
            msg.append("Email Already Exists. ");
        }
        if (!msg.isEmpty()) {
            throw new ValidationException(msg.toString());
        }
        UserDto responseUserDto = userService.addUser(userDto);
        return new ResponseEntity<>(responseUserDto, HttpStatus.OK);
    }


    //Update User Detail
    @PutMapping("/user/update")
    public ResponseEntity<?> updateDetails(@RequestBody UserDto userDto, BindingResult bindingResult) {
        StringBuilder msg = new StringBuilder();
        if (bindingResult.hasErrors()) {
            List<FieldError> allErrors = bindingResult.getFieldErrors();
            for (FieldError error : allErrors) {
                System.out.println(error.getDefaultMessage());
                msg.append(error.getDefaultMessage());
                msg.append("; ");
            }
        }
        Users availableUser = userService.findByUsername(userDto.getUsername());
        if (availableUser != null && !Objects.equals(availableUser.getId(), userDto.getId())) {
            msg.append("Username Already Exists. ");
        }
        availableUser = userService.findByEmail(userDto.getEmail());
        if (availableUser != null && !Objects.equals(availableUser.getId(), userDto.getId())) {
            msg.append("Email Already Exists");
        }
        if (!msg.isEmpty()) {
            throw new ValidationException(msg.toString());
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
