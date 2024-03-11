package com.example.GritAcademyAPI.courses;

import com.example.GritAcademyAPI.students.StudentsDTO;
import lombok.Data;

import java.util.List;

@Data
public class CoursesDTO {

    private Integer id;
    private String name;
    List<StudentsDTO> students;

}
