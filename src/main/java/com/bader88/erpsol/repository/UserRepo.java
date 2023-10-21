package com.bader88.erpsol.repository;

import com.bader88.erpsol.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
//    Spring Data Derived Query Methods

    List<UserEntity> findAllByLastName(String lastName);
    List<UserEntity> findAllByFirstNameAndLastName(String firstName,String lastName);
    List<UserEntity> findAllByFirstNameStartingWith (String firstName);
    List<UserEntity> findAllByFirstNameEndingWith (String firstName);
    List<UserEntity> findAllByFirstNameContaining (String firstName);
    List<UserEntity> findAllByOrderByFirstNameDesc ();
    List<UserEntity> findAllByOrderByFirstNameAsc ();
}