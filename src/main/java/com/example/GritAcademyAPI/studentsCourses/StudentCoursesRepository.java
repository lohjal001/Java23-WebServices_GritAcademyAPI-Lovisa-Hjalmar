package com.example.GritAcademyAPI.studentsCourses;

import com.example.GritAcademyAPI.students.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCoursesRepository extends CrudRepository<StudentCourses, Integer> {

}