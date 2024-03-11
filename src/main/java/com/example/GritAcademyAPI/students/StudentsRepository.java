package com.example.GritAcademyAPI.students;

import com.example.GritAcademyAPI.courses.Courses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends CrudRepository<Students, Integer> {

}