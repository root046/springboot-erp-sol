package com.bader88.erpsol.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user_notes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserNoteEntity {

    @Id
    @Column(name = "note_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noteId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "note")
    private String note;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private UserEntity userEntity;
}
