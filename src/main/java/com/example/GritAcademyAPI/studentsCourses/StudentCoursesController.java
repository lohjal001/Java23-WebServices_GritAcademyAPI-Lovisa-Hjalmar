package com.example.GritAcademyAPI.studentsCourses;


import com.example.GritAcademyAPI.students.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentCoursesController {

    @Autowired
    StudentsServices studentsServices;

    @GetMapping(value = "/student_courses", produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<StudentCourses> getStudentCourses(){
        return StudentCoursesServices.getStudentCourses();
    }
}

