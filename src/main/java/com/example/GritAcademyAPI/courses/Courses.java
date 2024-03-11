package com.example.GritAcademyAPI.courses;

import jakarta.persistence.*;

import lombok.Data;


@Entity(name = "courses")
@Table(name = "courses")
@Data
public class Courses {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Id
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;



}

