package com.example.photoappapiusers.controllers;

import com.example.photoappapiusers.dto.UserDto;
import com.example.photoappapiusers.entity.UserEntity;
import com.example.photoappapiusers.model.CreateUserRequestModel;
import com.example.photoappapiusers.model.CreateUserResponseModel;
import com.example.photoappapiusers.service.UsersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private Environment environment;


    UsersService usersService;
    CreateUserRequestModel userRequestModel;
    CreateUserResponseModel userResponseModel;
    @Autowired
    public UsersController(UsersService usersService, CreateUserRequestModel userRequestModel, CreateUserResponseModel userResponseModel) {
        this.usersService = usersService;
        this.userRequestModel = userRequestModel;
        this.userResponseModel = userResponseModel;
    }

    @GetMapping("/status/check")
    public String status(){
        return "users microservice working on port: " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody CreateUserRequestModel userDetails)
    {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
// Map request model to user dto, so that we can pass userdto ibject to service layer
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);

        UserDto createdUser = usersService.createUser(userDto);

        // Map respone object which is userdto to response model
        CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);

        // custom return status with response body
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }



@GetMapping("/getall")
    public List<UserEntity> getUsers(){

        return usersService.getAllUsers();
    }
}
