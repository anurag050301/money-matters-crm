package org.moneymatters.crm.service.serviceImpl;

import org.modelmapper.ModelMapper;
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
    private final ModelMapper userMapper;

    public UserServiceImpl(ModelMapper userMapper) {
        this.userMapper = userMapper;
    }

    // Convert User entity to UserDto
    public UserDto toDto(User user) {
        return userMapper.map(user, UserDto.class);
    }

    // Convert UserDto to User entity
    public User toEntity(UserDto userDto) {
        return userMapper.map(userDto, User.class);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>)userRepo.findAll();
    }

    @Override
    public UserDto getUser(long id) {
        User user = userRepo.findById(id).orElse(null);
        UserDto userDto = this.toDto(user);
        System.out.println(userDto);
        return userDto;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = this.toEntity(userDto);
        System.out.println(user);
        return this.toDto(userRepo.save(user));
    }

    @Override
    public UserDto updateUserDetails(UserDto userDto) {
        User user= this.toEntity(userDto);
        return this.toDto(userRepo.save(user));
    }

    @Override
    public String deleteUser(long id) {
        userRepo.deleteById(id);
        return "User Deleted Successfully.";
    }
}