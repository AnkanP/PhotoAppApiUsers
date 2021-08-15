package com.example.photoappapiusers.service;

import com.example.photoappapiusers.dao.UsersRepository;
import com.example.photoappapiusers.dto.UserDto;
import com.example.photoappapiusers.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class UserServiceImpl implements UsersService{

private final  UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDto createUser(UserDto userDetails) {
        // TODO Auto-generated method stub

        userDetails.setUserId(UUID.randomUUID().toString());

// MOdel mapper to convert dto to entity
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);

        // CRUD operations method in DAO class which can only accept entity object
        usersRepository.save(userEntity);

        UserDto returnValue = modelMapper.map(userEntity, UserDto.class);

        return returnValue;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public UserDto CreateUser_v1(UserEntity userDetails) {

        // Mask the database generated id by public id
        //userDetails.setUserId(UUID.randomUUID().toString());
        // Protect the user provided password with encrypted password


        // we need to map the dto object to the entity object.
        // for that we can use model mapper
        //ModelMapper modelMapper  = new ModelMapper();
        //modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);


        // <destination type>model mapper<source, destination type>
        //UsersEntity usersEntity = modelMapper.map(userDetails,UsersEntity.class);
        //temporary
        //usersEntity.setEncryptedPassword("test");
        usersRepository.save(userDetails);
        return null;
    }

}
