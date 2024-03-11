package com.example.GritAcademyAPI.students;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "students")
@Table(name = "students")
@Data
public class Students {



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Id
    private Long id;

    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
    @Column(name = "town")
    private String town;



}

