package com.bader88.erpsol.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {

    @JsonManagedReference
    @OneToOne(mappedBy = "userEntity")
    private UserAddressEntity userAddress;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active")
    private Integer isActive;

    @JsonManagedReference
    @OneToOne(mappedBy = "userEntity")
    private UserAddressEntity addressEntity;

    @JsonManagedReference
    @OneToMany(mappedBy = "userEntity")
    private List<UserNoteEntity> userNotes;

    @JsonManagedReference
    @OneToMany(mappedBy = "userEntity")
    private List<UserCourseEntity> userCourses;
}
