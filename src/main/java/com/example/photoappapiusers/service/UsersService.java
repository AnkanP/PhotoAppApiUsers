package com.example.photoappapiusers.service;


import com.example.photoappapiusers.dto.UserDto;
import com.example.photoappapiusers.entity.UserEntity;

import java.util.List;

public interface UsersService {
    public UserDto createUser(UserDto userDetails);
    public List<UserEntity> getAllUsers();
    public UserDto CreateUser_v1(UserEntity userDetails);
}
