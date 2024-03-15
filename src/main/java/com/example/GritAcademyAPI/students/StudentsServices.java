package com.example.GritAcademyAPI.students;

import com.example.GritAcademyAPI.ResourceNotFoundException;
import com.example.GritAcademyAPI.courses.Courses;
import com.example.GritAcademyAPI.courses.CoursesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentsServices {

    @Autowired
    StudentsRepository studentsRepository;
    public List<StudentsDTO> getStudents() {
        List<StudentsDTO> studentsDTOS = new ArrayList<>();
        studentsRepository.findAll().forEach(students -> studentsDTOS.add(this.mapToDTO(students)));
        return studentsDTOS;
    }

    public List<StudentsDTO> getStudentById(Long id){
        List<StudentsDTO> studentsDTOS = new ArrayList<>();
        studentsRepository.findById(id).map(students -> studentsDTOS.add(this.mapToDTO(students))).orElseThrow(() -> new ResourceNotFoundException("404 User not found with id " + id));
        return studentsDTOS;
    }
    public List<StudentsDTO> getStudentByFname(String fname){
        List<StudentsDTO> studentsDTOS = new ArrayList<>();
        studentsRepository.findByFname(fname).forEach(students -> studentsDTOS.add(this.mapToDTO(students)));
        return studentsDTOS;
    }

    public List<StudentsDTO> getStudentByLname(String lname){
        List<StudentsDTO> studentsDTOS = new ArrayList<>();
        studentsRepository.findByLname(lname).forEach(students -> studentsDTOS.add(this.mapToDTO(students)));
        return studentsDTOS;
    }

    public List<StudentsDTO> getStudentByTown(String town){
        List<StudentsDTO> studentsDTOS = new ArrayList<>();
        studentsRepository.findByTown(town).forEach(students -> studentsDTOS.add(this.mapToDTO(students)));
        return studentsDTOS;
    }

    private StudentsDTO mapToDTO(Students students) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setFname(students.getFname());
        dto.setLname(students.getLname());
        dto.setTown(students.getTown());
        dto.setCourses(students.getCourses().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    private CoursesDTO mapToDTO(Courses courses) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setDescription(courses.getDescription());

        return dto;
    }


}