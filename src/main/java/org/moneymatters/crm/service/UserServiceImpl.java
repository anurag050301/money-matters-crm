package org.moneymatters.crm.service;

import org.moneymatters.crm.entity.User;
import org.moneymatters.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User getUser(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public String addUser(User user) {
        User newUser = userRepo.save(user);
        return "User added Successfully.";
    }

    @Override
    public User updateUserDetails(User user) {
        return userRepo.save(user);
    }

    @Override
    public String deleteUser(long id) {
        userRepo.deleteById(id);
        return "User Deleted.";
    }
}