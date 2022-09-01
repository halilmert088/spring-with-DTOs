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

    @GetMapping("/showDTO")
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

    @GetMapping("/getStudent")
    public Student getStudentTest (@RequestParam (value = "num", defaultValue = "2") int num)
    {
        var users = (List<Student>) studentsInterface.findAll();
        return users.get(num);
    }

    @GetMapping("/showAllStudents")
    public List<Student> showAllStudents()
    {
        List<Student> users = studentsInterface.findAll();
        return users;
    }

    @GetMapping("/findById")
    public Optional<Student> findById(@RequestParam(value = "id", defaultValue = ("123456")) int id)
    {
        var users = studentsInterface.findById(id);
        return users;
    }
}
