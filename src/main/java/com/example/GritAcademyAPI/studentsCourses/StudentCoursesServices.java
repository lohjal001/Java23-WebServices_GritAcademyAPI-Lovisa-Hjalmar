package com.example.GritAcademyAPI.studentsCourses;

import com.example.GritAcademyAPI.students.Students;
import com.example.GritAcademyAPI.students.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCoursesServices {

    @Autowired
    StudentCoursesRepository studentCoursesRepository;

    //This is an example of infinite recursion / circular query problem
    //Taxicos have a list of Vehicles and Vehicles have a list of Taxicos
    //While trying to populated list, Spring Boot is going deeper and deeper
    //in populating next list. Check out getVehicles to see how to avoid this problem
    public Iterable<StudentCourses> getStudentCourses(){
        return studentCoursesRepository.findAll();
    }
}