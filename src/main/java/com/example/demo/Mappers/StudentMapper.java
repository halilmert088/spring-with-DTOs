package com.example.demo.Mappers;

import com.example.demo.DTO.*;
import com.example.demo.Databases.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public static StudentDTO map(Student student){
        return StudentDTO.builder().id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .phone(student.getPhone())
                .departmentDTO(DepartmentDTO.builder()
                        .id(student.getDept().getDeptId()).build()).build();
    }

    public static Student convertEntity (StudentDTO studentDTO)
    {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());
        student.setPhone(studentDTO.getPhone());
        DepartmentDTO departmentDTO = new DepartmentDTO();
        student.setDept(departmentDTO.convert(studentDTO.getDepartmentDTO()));
        return student;
    }
}

