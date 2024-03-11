package com.example.GritAcademyAPI.students;

import com.example.GritAcademyAPI.courses.Courses;
import com.example.GritAcademyAPI.courses.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsServices {

    @Autowired
    StudentsRepository studentsRepository;

    //This is an example of infinite recursion / circular query problem
    //Taxicos have a list of Vehicles and Vehicles have a list of Taxicos
    //While trying to populated list, Spring Boot is going deeper and deeper
    //in populating next list. Check out getVehicles to see how to avoid this problem
    public Iterable<Students> getStudents(){
        return studentsRepository.findAll();
    }
}