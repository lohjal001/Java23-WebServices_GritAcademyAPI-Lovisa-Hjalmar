package com.example.GritAcademyAPI.studentCourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCoursesServices {

    @Autowired
    StudentCoursesRepository studentCoursesRepository;

    public Iterable<StudentCourses> getStudentCourses(){
        return studentCoursesRepository.findAll();
    }
}