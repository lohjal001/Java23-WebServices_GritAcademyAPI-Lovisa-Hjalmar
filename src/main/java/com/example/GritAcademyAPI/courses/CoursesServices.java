package com.example.GritAcademyAPI.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursesServices {

    @Autowired
    CoursesRepository coursesRepository;

    //This is an example of infinite recursion / circular query problem
    //Taxicos have a list of Vehicles and Vehicles have a list of Taxicos
    //While trying to populated list, Spring Boot is going deeper and deeper
    //in populating next list. Check out getVehicles to see how to avoid this problem
    public Iterable<Courses> getCourses(){
        return coursesRepository.findAll();
    }
}