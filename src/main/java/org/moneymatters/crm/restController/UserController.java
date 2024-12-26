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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private View error;


    //Get all the Users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    //Get Users on the basis of id;
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable long id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }


    //Add a new User Detail
    @PostMapping("/user/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDto userDto,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String, List<String>> temp = new HashMap<>();
            List<FieldError> allErrors = bindingResult.getFieldErrors();
            List<String> sendErrors = new ArrayList<String>();
            for(FieldError error: allErrors){
                sendErrors.add(error.getDefaultMessage());
            }
//            allErrors.forEach(error -> sendErrors.add(error.getDefaultMessage()));
            temp.put("Errors",sendErrors);
            return new ResponseEntity<>(temp,HttpStatus.BAD_REQUEST);
        }
        UserDto responseUserDto = userService.addUser(userDto);
        return new ResponseEntity<>(responseUserDto, HttpStatus.OK);
    }


    //Update User Detail
    @PutMapping("/user/update")
    public ResponseEntity<UserDto> updateDetails(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.updateUserDetails(userDto), HttpStatus.OK);
    }


    //Delete User
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

}
