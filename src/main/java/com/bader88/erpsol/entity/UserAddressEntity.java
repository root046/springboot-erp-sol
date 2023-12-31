package com.bader88.erpsol.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user_address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserAddressEntity {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "address")
    private String address;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "user_id",insertable=false, updatable=false)
    private UserEntity userEntity;
}