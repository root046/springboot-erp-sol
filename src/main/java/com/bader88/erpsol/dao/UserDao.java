package com.bader88.erpsol.dao;

import com.bader88.erpsol.entity.UserEntity;
import com.bader88.erpsol.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDao {
    @Autowired
    private UserRepo userRepo;

    public List<UserEntity> getAllUsersBylastName(String lastName){

        return this.userRepo.findAllByLastName(lastName);
    }

    public List<UserEntity> findAllByFirstNameAndLastName(String firstName,String lastName){
        return this.userRepo.findAllByFirstNameAndLastName(firstName, lastName);
    }

    public List<UserEntity> findAllByFirstNameStartingWith (String firstName){
        return this.userRepo.findAllByFirstNameStartingWith(firstName);
    }
    public List<UserEntity> findAllByFirstNameEndingWith (String firstName){
        return this.userRepo.findAllByFirstNameEndingWith(firstName);
    }

    public List<UserEntity> findAllByFirstNameContaining (String firstName){
        return this.userRepo.findAllByFirstNameContaining(firstName);
    }

    public List<UserEntity> findAllByOrderByFirstNameDesc (){
        return this.userRepo.findAllByOrderByFirstNameDesc();
    }
    public List<UserEntity> findAllByOrderByFirstNameAsc (){
        return this.userRepo.findAllByOrderByFirstNameAsc();
    }
    public List<UserEntity> getAllUsersByDortClass (){
        return this.userRepo.findAll(Sort.by(Sort.Direction.ASC,"firstName","lastName"));
    }

}
