package org.moneymatters.crm.service;

import org.moneymatters.crm.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String validateUser(User user) {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            return "Username is required!";
        }
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            return "Password must be at least 6 characters long!";
        }
        return "User is valid!";
    }
}
