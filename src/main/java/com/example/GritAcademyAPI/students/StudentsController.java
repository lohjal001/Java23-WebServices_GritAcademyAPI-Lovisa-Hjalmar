package com.example.GritAcademyAPI.students;

import com.example.GritAcademyAPI.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class StudentsController {

    @Autowired
    StudentsServices studentsServices;

    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    List<StudentsDTO> getStudents(){
        return studentsServices.getStudents();
    }

    @GetMapping (value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<StudentsDTO>> searchStudentById (@PathVariable(value = "id") Long id) {
        if (id<0) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            List<StudentsDTO> students = studentsServices.getStudentById(id);
            return new ResponseEntity<>(students, HttpStatus.OK);
        }

    }

    @GetMapping (value = "/students/{}/{fname}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<StudentsDTO>> searchStudentsByFname (@PathVariable(value = "fname") String fname) {
    List<StudentsDTO> students = studentsServices.getStudentByFname(fname);
        if(students.isEmpty()){
            throw new ResourceNotFoundException("404 Student not found.");
        }
        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    @GetMapping (value = "/students/{}/{fname}/{lname}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<StudentsDTO>> searchStudentsByLname (@PathVariable(value = "lname") String lname) {
        List<StudentsDTO> students = studentsServices.getStudentByLname(lname);
        if(students.isEmpty()){
           throw new ResourceNotFoundException("404 Student not found.");
        }
        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    @GetMapping (value = "/students/{}/{fname}/{lname}/{town}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<StudentsDTO>> searchStudentsByTown (@PathVariable(value = "town") String town) {
        List<StudentsDTO> students = studentsServices.getStudentByTown(town);
        if(students.isEmpty()){
            throw new ResourceNotFoundException("404 Student not found.");
        }
        return new ResponseEntity<>(students, HttpStatus.OK);

    }


}