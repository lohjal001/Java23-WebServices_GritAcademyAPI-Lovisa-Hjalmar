package com.example.GritAcademyAPI.studentCourses;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCoursesRepository extends CrudRepository<StudentCourses, Integer> {

}