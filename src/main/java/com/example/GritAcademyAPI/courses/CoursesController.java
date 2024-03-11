package com.example.GritAcademyAPI.courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class CoursesController {

    @Autowired
    CoursesServices coursesServices;

    @GetMapping(value = "/taxicos", produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<Courses> getCourses(){
        return coursesServices.getCourses();
    }
}

