package com.example.GritAcademyAPI.courses;

import com.example.GritAcademyAPI.ResourceNotFoundException;
import com.example.GritAcademyAPI.students.Students;
import com.example.GritAcademyAPI.students.StudentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursesServices {

    @Autowired
    CoursesRepository coursesRepository;

    public List<CoursesDTO> getCourses() {
        List<CoursesDTO> coursesDTOS = new ArrayList<>();
        coursesRepository.findAll().forEach(courses -> coursesDTOS.add(this.mapToDTO(courses)));
        return coursesDTOS;
    }

    public List<CoursesDTO> getCoursesById(Long id){
        List<CoursesDTO> coursesDTOS = new ArrayList<>();
        coursesRepository.findById(id).map(courses -> coursesDTOS.add(this.mapToDTO(courses))).orElseThrow(() -> new ResourceNotFoundException("404 Course not found with " + id));
        return coursesDTOS;
    }

    public List<CoursesDTO> getCoursesByName(String name){
        List<CoursesDTO> coursesDTOS = new ArrayList<>();
        coursesRepository.findByName(name).forEach(courses -> coursesDTOS.add(this.mapToDTO(courses)));
        return coursesDTOS;
    }

    public List<CoursesDTO> getCoursesByContains(String title){
        List<CoursesDTO> coursesDTOS = new ArrayList<>();
        coursesRepository.findByNameContaining(title).forEach(courses -> coursesDTOS.add(this.mapToDTO(courses)));
        return coursesDTOS;
    }

    public List<CoursesDTO> getCoursesByDescription(String description){
        List<CoursesDTO> coursesDTOS = new ArrayList<>();
        coursesRepository.findByDescriptionContaining(description).forEach(courses -> coursesDTOS.add(this.mapToDTO(courses)));
        return coursesDTOS;
    }



    private CoursesDTO mapToDTO(Courses courses) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setDescription(courses.getDescription());
        dto.setStudents(courses.getStudents().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList()));

        return dto;
    }

    private StudentsDTO mapToDTO(Students students) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setFname(students.getFname());
        dto.setLname(students.getLname());
        dto.setTown(students.getTown());

        return dto;
    }


}