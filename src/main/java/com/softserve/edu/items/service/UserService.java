package com.softserve.edu.items.service;

import com.softserve.edu.items.dao.UserDao;
import com.softserve.edu.items.dto.LoginDto;
import com.softserve.edu.items.dto.RegisterDto;
import com.softserve.edu.items.dto.UserDto;
import com.softserve.edu.items.dto.UsersDto;
import com.softserve.edu.items.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

//    public boolean setUserDTO(UserDao userDao){
//
//    }

    //    // Update User
    public boolean setUserDto(UserDto userDto) {
        boolean result = true;
        User user = userDao.getUserEntityByUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        try {
//            user.setIdRole(roleDao.getRoleEntityByName(userDto.getRole()).getId());
            userDao.updateByEntity(user);
        } catch (Exception e) {

            System.out.println("RuntimeException, message: " + e.getMessage());
            result = false;
        }
        // User Exception
        return result;
    }
    //
    public UserDto getUserDto(LoginDto loginDto) {
        User user = userDao.getUserEntityByUsername(loginDto.getUsername());
        return new UserDto(user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getIsactive(),
                user.getIsadmin());
    }

    public boolean setRegisterDto(RegisterDto registerDto) {
        boolean result = true;
        try {
            userDao.insert(new User((long) 1, registerDto.getUsername(), registerDto.getEmail(), registerDto.getPassword()));
        } catch (Exception e) {
            System.out.println("RuntimeException, message: " + e.getMessage());
            result = false;
        }
        return result;
    }

    public UsersDto getUsersDto(int pageofset) {
        List<User> users = userDao.getAll();
        List<UserDto> userDtos = new ArrayList<>();
        User user;
        for (int i = 0; i < users.size(); i++) {
            user = users.get(i);
            userDtos.add(i, new UserDto(user.getUsername(), user.getEmail(), user.getPassword(), user.getIsactive(), user.getIsadmin()));
        }

        return new UsersDto(userDtos, pageofset);
    }

    public Long getIdUserByUsername(LoginDto loginDto) {

        return userDao.getUserEntityByUsername(loginDto.getUsername()).getId();
    }
    public Long getIdUserByUsername(String userName) {

        return userDao.getUserEntityByUsername(userName).getId();
    }

    public Long getIdUserByLogin(UserDto userDto) {
        return userDao.getUserEntityByUsername(userDto.getUsername()).getId();
    }

    //
    public boolean isValid(LoginDto loginDto) {
        boolean result = true;
        User user = null;
        try {
            user = userDao.getUserEntityByUsername(loginDto.getUsername());
        } catch (Exception e) {
            // Logging Exception
            System.out.println("RuntimeException, message: " + e.getMessage());
            result = false;
        }
        result = result && (user.getPassword().equals(loginDto.getPassword())&&user.getIsactive()!=(long)0);
        return result;
    }
}