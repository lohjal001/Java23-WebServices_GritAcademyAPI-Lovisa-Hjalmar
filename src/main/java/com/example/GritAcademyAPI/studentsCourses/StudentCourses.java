package com.example.GritAcademyAPI.studentsCourses;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Class representing the vehicles table in the DB
 */
@Entity(name = "student_courses")
@Table(name = "student_courses")
@Data
public class StudentCourses {

    //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Id
    private Long id;

    @Column(name = "course_id")
    private int courseId;
    @Column(name = "student_id")
    private int studentId;



}

