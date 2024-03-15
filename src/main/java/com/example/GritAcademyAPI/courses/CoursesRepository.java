package com.example.GritAcademyAPI.courses;

import com.example.GritAcademyAPI.students.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends CrudRepository<Courses, Long> {

    List<Courses> findByName(String name);
    List<Courses> findByNameContaining(String title);
    List<Courses> findByDescriptionContaining(String description);


}