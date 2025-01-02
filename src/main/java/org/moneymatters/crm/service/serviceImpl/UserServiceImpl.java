package org.moneymatters.crm.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.moneymatters.crm.dto.UserDto;
import org.moneymatters.crm.entity.Users;
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


    // Convert Users entity to UserDto
    public UserDto toDto(Users user) {
        UserDto userDto = userMapper.map(user,UserDto.class);
        return userDto;
    }

    // Convert UserDto to Users entity
    public Users toEntity(UserDto userDto) {
        Users responseUser = userMapper.map(userDto,Users.class);
        return responseUser;
    }

    @Override
    public Users findByUsername(String username){
        Users user = userRepo.findByUsername(username);
        return user;
    }

    @Override
    public Users findByEmail(String email) {
        Users user = userRepo.findByEmail(email);
        return user;
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> allUsers = (List<Users>) userRepo.findAll();
        return allUsers;
    }

    @Override
    public UserDto getUser(long id) {
        Users user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Users id:"+id+" Not Found."));
        UserDto userDto = this.toDto(user);
        return userDto;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        Users user = this.toEntity(userDto);
        UserDto responseUserDto = this.toDto(userRepo.save(user));
        return responseUserDto;
    }

    @Override
    public UserDto updateUserDetails(UserDto userDto) {
        Users user= this.toEntity(userDto);
        UserDto responseUserDto = this.toDto(userRepo.save(user));
        return responseUserDto;
    }

    @Override
    public String deleteUser(long id) {
        userRepo.deleteById(id);
        return "Users Deleted Successfully.";
    }
}