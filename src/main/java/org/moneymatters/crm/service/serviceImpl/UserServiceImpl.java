package org.moneymatters.crm.service.serviceImpl;

import org.moneymatters.crm.model.User;
import org.moneymatters.crm.repository.UserRepository;
import org.moneymatters.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public List<User> getAllUsers() {
        return (List<User>)userRepo.findAll();
    }

    @Override
    public User getUser(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUserDetails(User user) {
        User save = userRepo.save(user);
        return user;
    }

    @Override
    public String deleteUser(long id) {
        userRepo.deleteById(id);
        return "User Deleted Successfully.";
    }
}