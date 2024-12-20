package org.moneymatters.crm.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @PostMapping("/hello")
    public String getGreeting(@RequestHeader("name") String name){
        return "Hello "+name;
    }
    @PostMapping("/validate")
    public String validateUserData(@RequestHeader("username") String username,@RequestHeader("password") String password, @RequestHeader("name") String name){
        if(username.equals("Anurag_05") && password.equals("ad05"))
            return ("Welcome " + name);
        else
            return "Invalid User Details";
    }
}
