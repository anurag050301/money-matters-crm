package org.moneymatters.crm.service.serviceImpl;

import org.moneymatters.crm.component.UserMapper;
import org.moneymatters.crm.dto.UserDto;
import org.moneymatters.crm.entity.User;
import org.moneymatters.crm.repository.UserRepository;
import org.moneymatters.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public List<User> getAllUsers() {
        return (List<User>)userRepo.findAll();
    }

    @Override
    public UserDto getUser(long id) {
        UserDto userDto = userMapper.toDto(userRepo.findById(id).orElse(null));
        System.out.println(userDto);
        return userDto;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        System.out.println(user);
        return userMapper.toDto(userRepo.save(user));
    }

    @Override
    public UserDto updateUserDetails(UserDto userDto) {
        User user= userMapper.toEntity(userDto);
        return userMapper.toDto(userRepo.save(user));
    }

    @Override
    public String deleteUser(long id) {
        userRepo.deleteById(id);
        return "User Deleted Successfully.";
    }
}