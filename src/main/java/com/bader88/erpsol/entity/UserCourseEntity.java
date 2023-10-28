package com.bader88.erpsol.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user_courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserCourseEntity {
    @Transient
    private String courseName;



    @Id
    @Column(name = "uc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ucId;


    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "course_id")
    private String courseId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private UserEntity userEntity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "course_id",insertable = false,updatable = false)
    private CourseEntity courseEntity;

    public String getCourseName() {
        return this.courseEntity.getCourseName();
    }

}
