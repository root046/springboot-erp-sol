package com.bader88.erpsol.controller;

import com.bader88.erpsol.dao.UserDao;
import com.bader88.erpsol.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping(path = "/getAllUsersBylastName")
    public List<UserEntity> getAllUsers(@RequestParam String lastName){
        return this.userDao.getAllUsersBylastName(lastName);
    }
    @GetMapping(path = "/findAllByFirstNameLikeAndLastName")
    List<UserEntity> findAllByFirstNameLikeAndLastName(@RequestParam String firstName,@RequestParam String lastName){
        return this.userDao.findAllByFirstNameAndLastName(firstName, lastName);
    }
    @GetMapping(path = "/findAllByFirstNameStartingWith")
    public List<UserEntity> findAllByFirstNameStartingWith (@RequestParam String firstName){
        return this.userDao.findAllByFirstNameStartingWith(firstName);
    }
    @GetMapping(path = "/findAllByFirstNameEndingWith")
    public List<UserEntity> findAllByFirstNameEndingWith (@RequestParam  String firstName){
        return this.userDao.findAllByFirstNameEndingWith(firstName);
    }

    @GetMapping(path = "/findAllByFirstNameContaining")
    public List<UserEntity> findAllByFirstNameContaining (@RequestParam String firstName){
        return this.userDao.findAllByFirstNameContaining(firstName);
    }
    @GetMapping(path = "/findAllByOrderByFirstNameDesc")
    public List<UserEntity> findAllByOrderByFirstNameDesc (){
        return this.userDao.findAllByOrderByFirstNameDesc();
    }
    @GetMapping(path = "/findAllByOrderByFirstNameAsc")
    public List<UserEntity> findAllByOrderByFirstNameAsc (){
        return this.userDao.findAllByOrderByFirstNameAsc();
    }

    @GetMapping(path = "/getAllUsersByDortClass")
    public List<UserEntity> getAllUsersByDortClass (){
        return this.userDao.getAllUsersByDortClass();
    }
}
