package com.example.photoappapiusers.dao;

import com.example.photoappapiusers.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// arguments to JPa repository is the entity object & the data type of the primary key
public interface UsersRepository extends JpaRepository<UserEntity, Long> {
}
