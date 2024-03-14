package com.example.GritAcademyAPI.students;

import com.example.GritAcademyAPI.courses.Courses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends CrudRepository<Students, Integer> {

    List<Students> findById(Long id);

    List<Students> findByFname(String fname);

    List<Students> findByLname(String lname);

    List<Students> findByTown(String town);




}