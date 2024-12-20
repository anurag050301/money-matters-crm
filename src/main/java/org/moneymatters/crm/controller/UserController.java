package org.moneymatters.crm.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/hello")
    public String getGreeting(){
        return "hello user this is a Greeting Message from the creator";
    }
}
