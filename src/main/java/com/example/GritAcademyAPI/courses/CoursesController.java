package com.example.GritAcademyAPI.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class CoursesController {

    @Autowired
    CoursesServices coursesServices;

    @GetMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<Courses> getCourses(){
        return coursesServices.getCourses();
    }

    @GetMapping (value = "/courses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CoursesDTO>> searchCoursesById (@PathVariable(value = "id") Long id) {
        List<CoursesDTO> courses = coursesServices.getCoursesById(id);
        if(courses.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);

    }

    @GetMapping (value = "/courses/{}/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CoursesDTO>> searchCoursesByName (@PathVariable(value = "name") String name) {
        List<CoursesDTO> courses = coursesServices.getCoursesByName(name);
        if(courses.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);

    }

    @GetMapping (value = "/courses/{}/{}/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CoursesDTO>> getCoursesByContains (@PathVariable(value = "title") String title) {
        List<CoursesDTO> courses = coursesServices.getCoursesByContains(title);
        if(courses.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);

    }
}

