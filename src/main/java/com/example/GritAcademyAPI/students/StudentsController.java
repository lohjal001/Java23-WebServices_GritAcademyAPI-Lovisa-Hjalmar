package com.example.GritAcademyAPI.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        List<StudentsDTO> students = studentsServices.getStudentById(id);
        if(students.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    @GetMapping (value = "/students/{}/{fname}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<StudentsDTO>> searchStudentsByFname (@PathVariable(value = "fname") String fname) {
    List<StudentsDTO> students = studentsServices.getStudentByFname(fname);
        if(students.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    @GetMapping (value = "/students/{}/{fname}/{lname}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<StudentsDTO>> searchStudentsByLname (@PathVariable(value = "lname") String lname) {
        List<StudentsDTO> students = studentsServices.getStudentByLname(lname);
        if(students.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    @GetMapping (value = "/students/{}/{fname}/{lname}/{town}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<StudentsDTO>> searchStudentsByTown (@PathVariable(value = "town") String town) {
        List<StudentsDTO> students = studentsServices.getStudentByTown(town);
        if(students.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);

    }


}