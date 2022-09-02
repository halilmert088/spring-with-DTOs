package com.example.demo.Controllers;

import com.example.demo.Databases.Student;
import com.example.demo.Interfaces.studentsInterface;
import com.example.demo.DTO.*;
import com.example.demo.Mappers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private studentsInterface studentsInterface;

    @Autowired private StudentMapper studentMapper;

    @GetMapping("/findAllStudent")
    public StudentDTO showDTO(@RequestParam int num)
    {
        Student student = new Student();
        student = studentsInterface.findAll().get(num);

        StudentDTO studentDTO = new StudentDTO();
        DepartmentDTO departmentDTO = DepartmentDTO.deptBuilder.deptBuilderWith().name(student.getDept().getDeptName())
                .id(student.getDept().getDeptId()).build();

        studentDTO = StudentDTO.StudentBuilder.studentBuilderWith().id(student.getId()).name(student.getName())
                .surname(student.getSurname()).phone(student.getPhone()).dept(departmentDTO).build();

        return studentDTO;
    }

    @GetMapping("/findStudentById")
    public StudentDTO findById(@RequestParam(value = "id", defaultValue = ("123456")) int id)
    {
        var users = studentsInterface.findById(id);

        DepartmentDTO departmentDTO = DepartmentDTO.deptBuilder.deptBuilderWith()
                .name(users.get().getDept().getDeptName())
                .id(users.get().getDept().getDeptId())
                .build();

        StudentDTO studentDTO = StudentDTO.StudentBuilder.studentBuilderWith()
                .id(users.get().getId())
                .name(users.get().getName())
                .surname(users.get().getSurname())
                .phone(users.get().getPhone())
                .dept(departmentDTO)
                .build();

        return studentDTO;
    }
}
