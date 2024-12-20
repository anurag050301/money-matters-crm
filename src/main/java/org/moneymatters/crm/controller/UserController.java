package org.moneymatters.crm.controller;


import org.moneymatters.crm.model.User;
import org.moneymatters.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String getGreeting(@RequestHeader("name") String name) {
        return "Hello " + name;
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateUser(@RequestBody User user) {
        String validationMessage = userService.validateUser(user);
        return ResponseEntity.ok(validationMessage);
    }
}
