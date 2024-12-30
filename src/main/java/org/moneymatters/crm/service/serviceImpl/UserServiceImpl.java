package org.moneymatters.crm.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.moneymatters.crm.dto.UserDto;
import org.moneymatters.crm.entity.User;
import org.moneymatters.crm.exception.UserNotFoundException;
import org.moneymatters.crm.repository.UserRepository;
import org.moneymatters.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    ModelMapper userMapper;


    // Convert User entity to UserDto
    public UserDto toDto(User user) {
        UserDto userDto = userMapper.map(user,UserDto.class);
        return userDto;
    }

    // Convert UserDto to User entity
    public User toEntity(UserDto userDto) {
        User responseUser = userMapper.map(userDto,User.class);
        return responseUser;
    }

    @Override
    public User findByUsername(String username){
        User user = userRepo.findByUsername(username);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepo.findByEmail(email);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = (List<User>) userRepo.findAll();
        return allUsers;
    }

    @Override
    public UserDto getUser(long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User id:"+id+" Not Found."));
        UserDto userDto = this.toDto(user);
        return userDto;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = this.toEntity(userDto);
        UserDto responseUserDto = this.toDto(userRepo.save(user));
        return responseUserDto;
    }

    @Override
    public UserDto updateUserDetails(UserDto userDto) {
        User user= this.toEntity(userDto);
        UserDto responseUserDto = this.toDto(userRepo.save(user));
        return responseUserDto;
    }

    @Override
    public String deleteUser(long id) {
        userRepo.deleteById(id);
        return "User Deleted Successfully.";
    }
}