package com.example.GritAcademyAPI.students;


import com.example.GritAcademyAPI.courses.Courses;
import com.example.GritAcademyAPI.courses.CoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {

    @Autowired
    StudentsServices studentsServices;

    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<Students> getStudents(){
        return studentsServices.getStudents();
    }
}

