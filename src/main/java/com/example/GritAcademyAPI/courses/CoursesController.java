package com.example.GritAcademyAPI.courses;

import com.example.GritAcademyAPI.ResourceNotFoundException;
import com.example.GritAcademyAPI.students.StudentsDTO;
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
    List<CoursesDTO> getCourses(){
        return coursesServices.getCourses();
    }

    @GetMapping (value = "/courses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CoursesDTO>> searchCoursesById (@PathVariable(value = "id") Long id) {
        if (id<0) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            List<CoursesDTO> courses = coursesServices.getCoursesById(id);
            return new ResponseEntity<>(courses, HttpStatus.OK);
        }

    }

    @GetMapping (value = "/courses/{}/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CoursesDTO>> searchCoursesByName (@PathVariable(value = "name") String name) {
        List<CoursesDTO> courses = coursesServices.getCoursesByName(name);
        if(courses.isEmpty()){
            throw new ResourceNotFoundException("404 Course not found.");
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);

    }

    @GetMapping (value = "/courses/{}/{name}/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CoursesDTO>> getCoursesByContains (@PathVariable(value = "title") String title) {
        List<CoursesDTO> courses = coursesServices.getCoursesByContains(title);
        if(courses.isEmpty()){
            throw new ResourceNotFoundException("404 Course not found.");
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);

    }

    @GetMapping (value = "/courses/{}/{name}/{title}/{description}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CoursesDTO>> getCoursesByDescription (@PathVariable(value = "description") String description) {
        List<CoursesDTO> courses = coursesServices.getCoursesByDescription(description);
        if(courses.isEmpty()){
            throw new ResourceNotFoundException("404 Course not found.");
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);

    }


}

