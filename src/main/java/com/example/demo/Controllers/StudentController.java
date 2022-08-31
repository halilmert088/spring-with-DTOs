package com.example.demo.Controllers;

import com.example.demo.Databases.Students;
import com.example.demo.Interfaces.studentsInterface;
import com.example.demo.DTO.*;
import com.example.demo.Mappers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private studentsInterface studentsInterface;

    @Autowired private StudentMapper studentMapper;

    @GetMapping("/showDTO")
    public StudentDTO getStudent()
    {
        Students student = new Students();
        student = studentsInterface.findAll().get(2); //test value, will work on getting parameter from input

        StudentDTO studentDTO = new StudentDTO();
        StudentDTO.StudentBuilder.studentBuilderWith().id(student.getId()).name(student.getName())
                .surname(student.getSurname()).dept(DepartmentDTO.deptBuilder.deptBuilderWith()
                        .id(student.getDept().getDeptId()).build()).build();

        return studentDTO;
    }
}
