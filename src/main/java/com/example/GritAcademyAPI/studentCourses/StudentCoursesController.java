package com.example.GritAcademyAPI.studentCourses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentCoursesController {

    @Autowired
    StudentCoursesServices studentCoursesServices;

    @GetMapping(value = "/student_courses", produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<StudentCourses> getStudentCourses(){
        return studentCoursesServices.getStudentCourses();
    }
}

