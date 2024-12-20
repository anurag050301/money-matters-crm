package org.moneymatters.crm.service;

import org.moneymatters.crm.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final String DESIRED_USERNAME = "admin";
    private static final String DESIRED_PASSWORD = "admin123";


    public String validateUser(User user) {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            return "Username is required!";
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return "Password is required!";
        }
        if (DESIRED_USERNAME.equals(user.getUsername()) && DESIRED_PASSWORD.equals(user.getPassword())) {
            return "Welcome, " + user.getName() + "!";
        }
        return "Invalid user";
    }
}
